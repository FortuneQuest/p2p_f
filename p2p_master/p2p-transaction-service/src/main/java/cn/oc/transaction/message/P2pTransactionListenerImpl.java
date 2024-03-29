package cn.oc.transaction.message;

import cn.oc.common.domain.ProjectCode;
import cn.oc.transaction.entity.Project;
import cn.oc.transaction.mapper.ProjectMapper;
import cn.oc.transaction.service.ProjectService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@RocketMQTransactionListener(txProducerGroup ="PID_START_REPAYMENT")
public class P2pTransactionListenerImpl implements RocketMQLocalTransactionListener {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectMapper projectMapper;

    /**
     * 执行本地事务
     * @param msg
     * @param arg
     * @return
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        //1. 解析消息
        final JSONObject jsonObject = JSON.parseObject(new String((byte[])
                msg.getPayload()));
        Project project =
                JSONObject.parseObject(jsonObject.getString("project"), Project.class);

        //2. 执行本地事务
        Boolean result = projectService.updateProjectStatusAndStartRepayment(project);
        //3. 返回执行结果
        if(result){
            return RocketMQLocalTransactionState.COMMIT;
        }else{
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    /*
    执行事务回查
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        System.out.println("事务回查");
        //1. 解析消息
        final JSONObject jsonObject = JSON.parseObject(new String((byte[])
                msg.getPayload()));
        Project project =
                JSONObject.parseObject(jsonObject.getString("project"), Project.class);

        //2. 查询标的状态
        Project pro=projectMapper.selectById(project.getId());

        //3. 返回结果
        if(pro.getProjectStatus().equals(ProjectCode.REPAYING.getCode())){
            return RocketMQLocalTransactionState.COMMIT;
        }else{
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }
}
