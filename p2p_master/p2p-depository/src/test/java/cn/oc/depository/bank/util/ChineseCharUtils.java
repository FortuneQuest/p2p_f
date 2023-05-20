package cn.oc.depository.bank.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Random;

public class ChineseCharUtils {
    public static String ODD_CHINESE_CHARS = "厷厸厹厺厼厽厾叀叁参叄叅叆叇亝収叏叐叒叓叕叚叜叝叞"
        + "叠叧叨叭叱叴叵叺叻叼叽叾卟叿吀吁吂吅吆吇吋吒吔吖吘吙吚吜吡吢吣吤吥吧吩吪吭吮吰吱吲呐吷吺吽呁呃呄呅呇呉"
        + "呋呋呌呍呎呏呐呒呓呔呕呗呙呚呛呜呝呞呟呠呡呢呣呤呥呦呧周呩呪呫呬呭呮呯呰呱呲呴呶呵呷呸呹呺呻呾呿咀咁咂"
        + "咃咄咅咇咈咉咊咋咍咎咐咑咓咔咕咖咗咘咙咚咛咜咝咞咟咠咡咢咣咤咥咦咧咨咩咪咫咬咭咮咯咰咲咳咴咵咶啕咹咺咻"
        + "呙咽咾咿哂哃哅哆哇哈哊哋哌哎哏哐哑哒哓哔哕哖哗哘哙哚哛哜哝哞哟哠咔哣哤哦哧哩哪哫哬哯哰唝哵哶哷哸哹哻哼"
        + "哽哾哿唀唁唂唃呗唅唆唈唉唊唋唌唍唎唏唑唒唓唔唣唖唗唘唙吣唛唜唝唞唟唠唡唢唣唤唥唦唧唨唩唪唫唬唭唯唰唲唳"
        + "唴唵唶唷念唹唺唻唼唽唾唿啀啁啃啄啅啇啈啉啋啌啍啎问啐啑啒启啔啕啖啖啘啙啚啛啜啝哑启啠啡唡衔啥啦啧啨啩啪"
        + "啫啬啭啮啯啰啱啲啳啴啵啶啷啹啺啻啼啽啾啿喀喁喂喃善喅喆喇喈喉喊喋喌喍喎喏喐喑喒喓喔喕喖喗喙喛喞喟喠喡喢"
        + "喣喤喥喦喨喩喯喭喯喰喱哟喳喴喵営喷喸喹喺喼喽喾喿嗀嗁嗂嗃嗄嗅呛啬嗈嗉唝嗋嗌嗍吗嗏嗐嗑嗒嗓嗕嗖嗗嗘嗙呜嗛"
        + "嗜嗝嗞嗟嗠嗡嗢嗧嗨唢嗪嗫嗬嗭嗮嗰嗱嗲嗳嗴嗵哔嗷嗸嗹嗺嗻嗼嗽嗾嗿嘀嘁嘂嘃嘄嘅嘅嘇嘈嘉嘊嘋嘌喽嘎嘏嘐嘑嘒嘓"
        + "呕嘕啧嘘嘙嘚嘛唛嘝嘞嘞嘟嘠嘡嘢嘣嘤嘥嘦嘧嘨哗嘪嘫嘬嘭唠啸囍嘴哓嘶嘷呒嘹嘺嘻嘼啴嘾嘿噀噂噃噄咴噆噇噈噉噊"
        + "噋噌噍噎噏噐噑噒嘘噔噕噖噗噘噙噚噛噜咝噞噟哒噡噢噣噤哝哕噧噩噪噫噬噭噮嗳噰噱哙噳喷噵噶噷吨噺噻噼噽噾噿"
        + "咛嚁嚂嚃嚄嚅嚆吓嚈嚉嚊嚋哜嚍嚎嚏尝嚑嚒嚓嚔噜嚖嚗嚘啮嚚嚛嚜嚝嚞嚟嚠嚡嚢嚣嚤呖嚧咙嚩咙嚧嚪嚫嚬嚭嚯嚰嚱亸"
        + "喾嚵嘤嚷嚸嚹嚺嚻嚼嚽嚾嚿啭嗫嚣囃囄冁囆囇呓囊囋囍囎囏囐嘱囒啮囔囕囖囘囙囜囝回囟囡団囤囥囦囧囨囩囱囫囬囮"
        + "囯困囱囲図囵囶囷囸囹囻囼图囿圀圁圂圂圃圄圅圆囵圈圉圊国圌圎圏圎圐圑园圆圔圕图圗团圙圚圛圜圝圞凹凸圠圡圢"
        + "圤圥圦圧圩圪圫圬圮圯地圱圲圳圴圵圶圷圸圹圻圼埢鴪址坁坂坃坄坅坆坈坉坊坋坌坍坒坓坔坕坖坘坙坜坞坢坣坥坧坨"
        + "坩坪坫坬坭坮坯垧坱坲坳坴坶坸坹坺坻坼坽坾坿垀垁垃垅垆垇垈垉垊垌垍垎垏垐垑垓垔垕垖垗垘垙垚垛垜垝垞垟垠垡"
        + "垤垥垧垨垩垪垫垬垭垮垯垰垱垲垲垳垴埯垶垷垸垹垺垺垻垼垽垾垽垿埀埁埂埃埄埅埆埇埈埉埊埋埌埍城埏埐埑埒埓埔"
        + "埕埖埗埘埙埚埛野埝埞域埠垭埢埣埤埥埦埧埨埩埪埫埬埭埮埯埰埱埲埳埴埵埶执埸培基埻崎埽埾埿堀堁堃堄坚堆堇堈"
        + "堉垩堋堌堍堎堏堐堑堒堓堔堕垴堗堘堙堚堛堜埚堞堟堠堢堣堥堦堧堨堩堫堬堭堮尧堰报堲堳场堶堷堸堹堺堻堼堽堾堼"
        + "堾碱塀塁塂塃塄塅塇塆塈塉块茔塌塍塎垲塐塑埘塓塕塖涂塘塙冢塛塜塝塟塠墘塣墘塥塦塧塨塩塪填塬塭塮塯塰塱塲塳"
        + "塴尘塶塷塸堑塺塻塼塽塾塿墀墁墂墄墅墆墇墈墉垫墋墌墍墎墏墐墒墒墓墔墕墖墘墖墚墛坠墝增墠墡墢墣墤墥墦墧墨墩"
        + "墪樽墬墭堕墯墰墱墲坟墴墵垯墷墸墹墺墙墼墽垦墿壀壁壂壃壄壅壆坛壈壉壊垱壌壍埙壏壐壑壒压壔壕壖壗垒圹垆壛壜"
        + "壝垄壠壡坜壣壤壥壦壧壨坝塆圭壭壱売壳壴壵壶壷壸壶壻壸壾壿夀夁夃夅夆夈変夊夌夎夐夑夒夓夔夗夘夛夝夞夡夣夤"
        + "夥夦夨夨夬夯夰夲夳夵夶夹夻夼夽夹夿奀奁奃奂奄奃奅奆奊奌奍奏奂奒奓奘奙奚奛奜奝奞奟奡奣奤奦奨奁奫妸奯奰奱"
        + "奲奵奺奻奼奾奿妀妁妅妉妊妋妌妍妎妏妐妑妔妕妗妘妚妛妜妟妠妡妢妤妦妧妩妫妭妮妯妰妱妲妴妵妶妷妸妺妼妽妿姀"
        + "姁姂姃姄姅姆姇姈姉姊姌姗姎姏姒姕姖姘姙姛姝姞姟姠姡姢姣姤姥奸姧姨姩姫姬姭姮姯姰姱姲姳姴姵姶姷姸姹姺姻姼"
        + "姽姾娀威娂娅娆娈娉娊娋娌娍娎娏娐娑娒娓娔娕娖娗娙娚娱娜娝娞娟娠娡娢娣娤娥娦娧娨娩娪娫娬娭娮娯娰娱娲娳娴"
        + "娵娷娸娹娺娻娽娾娿婀娄婂婃婄婅婇婈婋婌婍婎婏婐婑婒婓婔婕婖婗婘婙婛婜婝婞婟婠婡婢婣婤婥妇婧婨婩婪婫娅婮"
        + "婯婰婱婲婳婵婷婸婹婺婻婼婽婾婿媀媁媂媄媃媅媪媈媉媊媋媌媍媎媏媐媑媒媓媔媕媖媗媘媙媚媛媜媝媜媞媟媠媡媢媣"
        + "媤媥媦媨媩媪媫媬媭妫媰媱媲媳媴媵媶媷媸媹媺媻媪媾嫀嫃嫄嫅嫆嫇嫈嫉嫊袅嫌嫍嫎嫏嫐嫑嫒嫓嫔嫕嫖妪嫘嫙嫚嫛嫜"
        + "嫝嫞嫟嫠嫡嫢嫣嫤嫥嫦嫧嫨嫧嫩嫪嫫嫬嫭嫮嫯嫰嫱嫲嫳嫴嫳妩嫶嫷嫸嫹嫺娴嫼嫽嫾婳妫嬁嬂嬃嬄嬅嬆嬇娆嬉嬊娇嬍嬎"
        + "嬏嬐嬑嬒嬓嬔嬕嬖嬗嬘嫱嬚嬛嬜嬞嬟嬠嫒嬢嬣嬥嬦嬧嬨嬩嫔嬫嬬奶嬬嬮嬯婴嬱嬲嬳嬴嬵嬶嬷婶嬹嬺嬻嬼嬽嬾嬿孀孁孂"
        + "娘孄孅孆孇孆孈孉孊娈孋孊孍孎孏嫫婿媚孑孒孓孖孚孛孜孞孠孡孢孥学孧孨孪孙孬孭孮孯孰孱孲孳孴孵孶孷孹孻孼孽"
        + "孾宄宆宊宍宎宐宑宒宓宔宖実宥宧宨宩宬宭宯宱宲宷宸宺宻宼寀寁寃寈寉寊寋寍寎寏寔寕寖寗寘寙寚寜寝寠寡寣寥寪"
        + "寭寮寯寰寱寲寳寴寷寽対尀専尃尅尌尐尒尕尗尛尜尞尟尠尣尢尥尦尨尩尪尫尬尭尮尯尰尲尳尴尵尶尾屃届屇屈屎屐屑"
        + "屒屓屔屖屗屘屙屚屛屉扉屟屡屣履屦屧屦屩屪屫属敳屮屰屲屳屴屵屶屷屸屹屺屻屼屽屾屿岃岄岅岆岇岈岉岊岋岌岍岎"
        + "岏岐岑岒岓岔岕岖岘岙岚岜岝岞岟岠岗岢岣岤岥岦岧岨岪岫岬岮岯岰岲岴岵岶岷岹岺岻岼岽岾岿峀峁峂峃峄峅峆峇峈"
        + "峉峊峋峌峍峎峏峐峑峒峓崓峖峗峘峚峙峛峜峝峞峟峠峢峣峤峥峦峧峨峩峪峬峫峭峮峯峱峲峳岘峵峷峸峹峺峼峾峿崀崁"
        + "崂崃崄崅崆崇崈崉崊崋崌崃崎崏崐崒崓崔崕崖崘崚崛崜崝崞崟岽崡峥崣崤崥崦崧崨崩崪崫崬崭崮崯崰崱崲嵛崴崵崶崷"
        + "崸崹崺崻崼崽崾崿嵀嵁嵂嵃嵄嵅嵆嵇嵈嵉嵊嵋嵌嵍嵎嵏岚嵑岩嵓嵔嵕嵖嵗嵘嵙嵚嵛嵜嵝嵞嵟嵠嵡嵢嵣嵤嵥嵦嵧嵨嵩嵪"
        + "嵫嵬嵭嵮嵯嵰嵱嵲嵳嵴嵵嵶嵷嵸嵹嵺嵻嵼嵽嵾嵿嶀嵝嶂嶃崭嶅嶆岖嶈嶉嶊嶋嶌嶍嶎嶏嶐嶑嶒嶓嵚嶕嶖嶘嶙嶚嶛嶜嶝嶞"
        + "嶟峤嶡峣嶣嶤嶥嶦峄峃嶩嶪嶫嶬嶭崄嶯嶰嶱嶲嶳岙嶵嶶嶷嵘嶹岭嶻屿岳帋巀巁巂巃巄巅巆巇巈巉巊岿巌巍巎巏巐巑峦"
        + "巓巅巕岩巗巘巙巚巛巜巠巡巢巣巤匘巪巬巭巯巵巶巸卺巺巼巽巿帀币帄帇帉帊帋帍帎帏帑帒帓帔帗帙帚帞帟帠帡帢帣"
        + "帤帨帩帪帬帯帰帱帲帴帵帷帹帺帻帼帽帾帿帧幁幂帏幄幅幆幇幈幉幊幋幌幍幎幏幐幑幒幓幖幙幚幛幜幝幞帜幠幡幢幤"
        + "幥幦幧幨幩幪幭幮幯幰幱幷幺吆玄幼兹滋庀庁仄広庅庇庈庉庋庌庍庎庑庖庘庛庝庞庠庡庢庣庤庥庨庩庪库庬庮庯庰庱"
        + "庲庳庴庵庹庺庻庼庽庿廀厕廃厩廅廆廇廋廌廍庼廏廐廑廒廔廕廖廗廘廙廛廜廞庑廤廥廦廧廨廭廮廯廰痈廲廵廸廹廻廼"
        + "廽廿弁弅弆弇弉弋弌弍弎弐弑弖弙弚弜弝弞弡弢弣弤弨弩弪弫弬弭弮弰弲弪弴弶弸弻弼弽弿彀彁彂彃彄彅彇彉彋弥彍"
        + "彏彑彔彖彗彘彚彛彜彝彞彟彡彣彧彨彭彮彯彲澎彳彴彵彶彷彸役彺彻彽彾佛徂徃徆徇徉后徍徎徏径徒従徔徕徖徙徚徛"
        + "徜徝从徟徕御徢徣徤徥徦徧徨复循徫旁徭微徯徰徱徲徳徴徵徶德徸彻徺徻徼徽徾徿忀忁忂忄惔愔忇忈忉忊忋忎忏忐忑"
        + "忒忓忔忕忖忚忛応忝忞忟忡忢忣忥忦忨忩忪忬忭忮忯忰忱忲忳忴念忶汹忸忹忺忻忼忾忿怂怃怄怅怆怇怈怉怊怋怌怍怏"
        + "怐怑怓怔怗怘怙怚怛怞怟怡怢怣怤怦怩怫怬怭怮怯怰怲怳怴怵怶怷怸怹怺怼悙怿恀恁恂恃恄恅恒恇恈恉恊恌恍恎恏恑"
        + "恒恓恔恖恗恘恙恚恛恜恝恞恠恡恦恧恫恬恮恰恱恲恴恷恹恺恻恽恾恿悀悁悂悃悆悇悈悊悋悌悍悎悏悐悑悒悓悕悖悗悘"
        + "悙悚悛悜悝悞悟悡悢悤悥悧悩悪悫悭悮悰悱悳悴悷悹悺悻悼悾悿惀惁惂惃惄惆惈惉惊惋惌惍惎惏惐惑惒惓惔惕惖惗惘"
        + "惙惚惛惜惝惞惠恶惢惣惤惥惦惧惨惩惪惫惬惮恼恽惴惵惶惸惺惼惽惾惿愀愂愃愄愅愆愇愉愊愋愌愍愎愐愑愒愓愕愖愗"
        + "愘愙愝愞愠愡愢愣愥愦愧愩愪愫愬愭愮愯愰愱愲愳怆愵愶恺愸愹愺愻愼愽忾愿慀慁慂慃栗慅慆慈慉慊态慏慐慑慒慓慔"
        + "慖慗惨慙惭慛慜慝慞恸慠慡慢慥慦慧慨慩怄怂慬悯慯慰慲悭慴慵慷慸慹慺慻慽慿憀憁忧憃憄憅憆憇憈憉惫憋憌憍憎憏"
        + "怜憓憔憕憖憗憘憙憛憜憝憞憟憠憡憢憣愤憥憦憧憨憩憪憬憭怃憯憰憱憳憴憵忆憷憸憹憺憻憼憽憾憿懀懁懂懄懅懆恳懈"
        + "懊懋怿懔懎懏懐懑懓懔懕懖懗懘懙懚懛懜懝怼懠懡懢懑懤懥懦懧恹懩懪懫懬懭懮懯懰懱惩懳懴懵懒怀悬懹忏懻惧懽慑"
        + "懿恋戁戂戃戄戅戆懯戉戊戋戌戍戎戓戋戕彧或戗戙戛戜戝戞戟戠戡戢戣戤戥戦戗戨戬截戫戭戮戱戳戴戵戈戚残牋戸戹"
        + "戺戻戼戽戾扂扃扄扅扆扈扊扏扐払扖扗扙扚扜扝扞扟扠扦扢扣扤扥扦扨扪扭扮扰扲扴扵扷扸抵扻扽抁挸抆抇抈抉抋抌"
        + "抍抎抏抐抔抖抙抝択抟抠抡抣护抦抧抨抩抪抬抮抰抲抳抵抶抷抸抹抺押抻抽抾抿拀拁拃拄拇拈拊拌拎拏拑拓拕拗拘拙"
        + "拚拝拞拠拡拢拣拤拧择拪拫括拭拮拯拰拱拲拳拴拵拶拷拸拹拺拻拼拽拾拿挀挂挃挄挅挆挈挊挋挌挍挎挏挐挒挓挔挕挗"
        + "挘挙挚挛挜挝挞挟挠挡挢挣挦挧挨挩挪挫挬挭挮挰挱挲挳挴挵挷挸挹挺挻挼挽挿捀捁捂捃捄捅捆捇捈捊捋捌捍捎捏捐"
        + "捑捒捓捔捕捖捗捘捙捚捛捜捝捞损捠捡换捣捤捥捦捧舍捩捪扪捬捭据捯捰捱捳捴捵捶捷捸捹捺捻捼捽捾捿掀掁掂扫抡"
        + "掅掆掇授掉掊掋掍掎掐掑排掓掔掕挜掖掘挣掚挂掜掝掞掟掠采探掣掤掦措掫掬掭掮掯掰掱掲掳掴掵掶掸掹掺掻掼掽掾"
        + "掿拣揁揂揃揅揄揆揇揈揉揊揋揌揍揎揑揓揔揕揖揗揘揙揜揝揞揟揠揢揤揥揦揧揨揫捂揰揱揲揳援揵揶揷揸揻揼揾揿搀"
        + "搁搂搃搄搅搇搈搉搊搋搌搎搏搐搑搒搓搔搕搘搙搚搛搝擀搠搡搢搣搤捶搦搧搨搩搪搫搬搮搰搱搲搳搴搵搷搸搹搻搼搽"
        + "榨搿摂摅摈摉摋摌摍摎摏摐掴摒摓摔摕摖摗摙摚摛掼摝摞摠摡摢揸摤摥摦摧摨摪摫摬摭摮挚摰摱摲抠摴摵抟摷摹摺掺"
        + "摼摽摾摿撀撁撂撃撄撅撉撊撋撌撍撎挦挠撒挠撔撖撗撘撙捻撛撜撝挢撠撡掸掸撧撨撩撪撬撮撯撱揿撴撵撶撷撸撹撺挞"
        + "撼撽挝擀擃掳擅擆擈擉擌擎擏擐擑擓擕擖擗擘擙擛擜擝擞擟擡擢擤擥擧擨擩擪擫擭擮摈擳擵擶撷擸擹擽擿攁攂攃摅攅"
        + "撵攇攈攉攊攋攌攍攎拢攐攑攒攓攕撄攗攘搀攚撺攞攟攠攡攒挛攥攦攧攨攩搅攫攭攮攰攱攲攳攴攵攸攺攼攽敀敁敂敃敄"
        + "敆敇敉敊敋敍敐敒敓敔敕敖敚敜敟敠敡敤敥敧敨敩敪敫敭敮敯敱敳敶敹敺敻敼敽敾敿斀斁敛斄斅斆敦斈斉斊斍斎斏斒"
        + "斓斔斓斖斑斘斚斛斝斞斟斠斡斢斣斦斨斪斫斩斮斱斲斳斴斵斶斸斺斻於斾斿旀旃旄旆旇旈旊旍旎旐旑旒旓旔旕旖旘旙"
        + "旚旜旝旞旟旡旣旤兂旪旫旮旯旰旱旲旳旴旵旸旹旻旼旽旾旿昀昁昃昄昅昈昉昊昋昍昐昑昒昕昖昗昘昙昚昛昜昝晻昢昣"
        + "昤春昦昧昩昪昫昬昮昰昱昲昳昴昵昶昷昸昹昺昻昼昽昿晀晁时晃晄晅晆晇晈晋晊晌晍晎晏晐晑晒晓晔晕晖晗晘晙晛晜"
        + "晞晟晠晡晰晣晤晥晦晧晪晫晬晭晰晱晲晳晴晵晷晸晹晻晼晽晾晿暀暁暂暃暄暅暆暇晕晖暊暋暌暍暎暏暐暑暒暓暔暕暖"
        + "暗旸暙暚暛暜暝暞暟暠暡暣暤暥暦暧暨暩暪暬暭暮暯暰昵暲暳暴暵暶暷暸暹暺暻暼暽暾暿曀曁曂曃晔曅曈曊曋曌曍曎"
        + "曏曐曑曒曓曔曕曗曘曙曚曛曜曝曞曟旷曡曢曣曤曥曦曧昽曩曪曫晒曭曮曯曰曱曵曶曷曹曺曻曽朁朂朄朅朆朇最羯肜朊"
        + "朌朎朏朐朑朒朓朕朖朘朙朚朜朞朠朡朣朤朥朦胧朩术朰朲朳枛朸朹朻朼朾朿杁杄杅杆圬杈杉杊杋杍杒杓杔杕杗杘杙杚"
        + "杛杝杞杢杣杤杦杧杩杪杫杬杮柿杰东杲杳杴杵杶杷杸杹杺杻杼杽枀枂枃枅枆枇枈枊枋枌枍枎枏析枑枒枓枔枖枘枙枛枞"
        + "枟枠枡枤枥枦枧枨枩枬枭枮枰枱枲枳枵枷枸枹枺枻枼枽枾枿柀柁柂柃柄柅柆柇柈柉柊柋柌柍柎柒柕柖柗柘柙查楂呆柙"
        + "柚柛柜柝柞柟柠柡柢柣柤柦柧柨柩柪柬柭柮柯柰柲柳栅柶柷柸柹拐査柼柽柾栀栁栂栃栄栆栈栉栊栋栌栍栎栐旬栔栕栗"
        + "栘栙栚栛栜栝栞栟栠栢栣栤栥栦栧栨栩株栫栬栭栮栯栰栱栲栳栴栵栶核栺栻栽栾栿桀桁桂桄桅桇桉桊桋桍桎桏桒桕桖"
        + "桗桘桙桚桛桜桝桞桟桠桡桢档桤桦桧桨桩桪桫桬桭杯桯桰桱桲桳桴桵桶桷桸桹桺桻桼桽桾杆梀梁梂梃梄梅梆梇梈梉枣"
        + "梌梍梎梏梐梑梒梓梕梖梗枧梙梚梛梜梞梠梡梢梣梤梥梧梩梪梫梬梭梮梯械梲梴梵梶梷梸梹梺梻梼梽梾梿检棁棂棃棅棆"
        + "棇棈棉棊棋棌棍棎棏棐棒棓棔棕枨枣棘棙棚棛棜棝棞栋棠棡棢棣棤棥棦棨棩棪棫桊棭棯棰棱栖棳棴棵梾棷棸棹棺棻棼"
        + "棽棾棿椀椁椂椃椄椆椇椈椉椊椋椌椎桠椐椒椓椔椕椖椗椘椙椚椛検椝椞椟椠椡椢椣椤椥椦椧椨椩椪椫椬椭椮椯椰椱椲"
        + "椳椴椵椶椷椸椹椺椻椼椽椾椿楀楁楂楃楅楆楇楈楉杨楋楌楍楎楏楐楑楒楔楕楖楗楘楛楜楝楞楟楠楡楢楣楤楥楦楧桢楩"
        + "楪楫楬楮椑楯楰楱楲楳楴极楶榉榊榋榌楷楸楹楺楻楽楾楿榀榁榃榄榅榆榇榈榉榊榋榌榍槝搌榑榒榓榔榕榖榗榘榙榚榛"
        + "榜榝榞榟榠榡榢榣榤榥榧榨榩杩榫榬榭榯榰榱榲榳榴榵榶榷榸榹榺榻榼榽榾桤槀槁槂盘槄槅槆槇槈槉槊构槌枪槎槏槐"
        + "槑槒杠槔槕槖槗様槙槚槛槜槝槞槟槠槡槢槣槥槦椠椁槩槪槫槬槭槮槯槰槱槲桨槴槵槶槷槸槹槺槻槼槽槾槿樀桩樃樄枞"
        + "樆樇樈樉樊樋樌樍樎樏樐樒樔樕樖樗樘樚樛樜樝樟樠樢样樤樥樦樧樨権横樫樬樭樮樯樰樱樲樳樴樵樶樷朴树桦樻樼樽"
        + "樾樿橀橁橂橃橄橅橆橇桡橉橊桥橌橍橎橏橐橑橒橓橔橕橖橗橘橙橚橛橜橝橞橠橡椭橣橤橥橧橨橩橪橬橭橮橯橰橱橲橳"
        + "橴橵橶橷橸橹橺橻橼柜橿檀檩檂檃檄檅檆檇檈柽檊檋檌檍檎檏檐檑檒檓档檕檖檗檘檙檚檛桧檝檞槚檠檡检樯檤檥檦檧"
        + "檨檩檪檫檬檭梼檰檱檲槟檴檵檶栎柠檹檺槛檼檽桐檿櫀櫁棹柜櫄櫅櫆櫇櫈櫉櫊櫋櫌櫍櫎櫏累櫑櫒櫔櫕櫖櫗櫘櫙榈栉櫜"
        + "椟橼櫠櫡櫢櫣櫤橱櫦槠栌櫩枥橥榇櫭櫮櫯櫰櫱櫲栊櫴櫵櫶櫷榉櫹櫼櫽櫾櫿欀欁欂欃栏欅欆欇欈欉权欋欌欍欎椤欐欑栾"
        + "欓欔欕榄欗欘欙欚欛欜欝棂欟欤欥欦欨欩欪欫欬欭欮欯欰欱欳欴欵欶欷唉欹欻欼钦款欿歀歁歂歃歄歅歆歇歈歉歊歋歍"
        + "欧歑歒歓歔殓歗歘歙歚歛歜歝歞欤歠欢钦歧歨歩歫歬歭歮歯歰歱歳歴歵歶歾殁殁殂殃殄殅殆殇殈殉殌殍殎殏殐殑殒殓"
        + "殔殕殖殗残殙殚殛殜殝殒殟殠殡殢殣殇殥殦殧殨殩殪殚殬殰殱歼殶殸殹殾殿毂毃毄毅殴毇毈毉毊母毋毎毐毑毓坶拇毖"
        + "毗毘坒陛屁芘楷砒玭昆吡纰妣锴鈚秕庇沘毜毝毞毟毠毡毢毣毤毥毦毧毨毩毪毫毬毭毮毯毰毱毲毳毴毵毶毷毸毹毺毻毼"
        + "毽毾毵氀氁氂氃氋氄氅氆氇毡氉氊氍氎氒氐抵坻坁胝阍痻泜汦茋芪柢砥奃睧眡蚳蚔呧軧軝崏弤婚怟惛忯岻貾氕氖気氘"
        + "氙氚氜氝氞氟氠氡氢氤氥氦氧氨氩氪氭氮氯氰氱氲氶氷凼氺氻氼氽氾氿汀汃汄汅氽汈汊汋汌泛汏汐汑汒汓汔汕汖汘污"
        + "汚汛汜汞汢汣汥汦汧汨汩汫汬汭汮汯汰汱汲汳汴汵汶汷汸汹汻汼汾汿沀沂沃沄沅沆沇沊沋沌冱沎沏洓沓沔沕沗沘沚沛"
        + "沜沝沞沠沢沣沤沥沦沨沩沪沫沬沭沮沯沰沱沲沴沵沶沷沸沺沽泀泂泃泅泆泇泈泋泌泍泎泏泐泑泒泓泔泖泗泘泙泚泜溯"
        + "泞泟泠泤泦泧泩泫泬泭泮泯泱泲泴泵泶泷泸泹泺泾泿洀洂洃洄洅洆洇洈洉洊洌洍洎洏洐洑洒洓洔洕洖洘洙洚洜洝洠洡"
        + "洢洣洤洦洧洨洫洬洭洮洯洰洱洳洴洵洷洸洹洺洼洽洿浀浂浃浄浈浉浊浌浍浏浐浒浔浕浖浗浘浚浛浜浝浞浟浠浡浢浣浤"
        + "浥浦浧浨浫浭浯浰浱浲浳浵浶浃浺浻浼浽浾浿涀涁涂涃涄涅涆泾涊涋涍涎涐涑涒涓涔涖涗涘涙涚涜涝涞涟涠涡涢涣涤"
        + "涥涧涪涫涬涭涰涱涳涴涶涷涸涹涺涻凉涽涾涿淁淂淃淄淅淆淇淈淉淊淌淍淎淏淐淓淔淕淖淗淙淛淜淞淟淠淢淣淤渌淦"
        + "淧沦淬淭淯淰淲淳淴涞滍淾淿渀渁渂渃渄渆渇済渋渌渍渎渏渑渒渓渕渖渘渚渜渝渞渟沨渥渧渨渪渫渮渰渱渲渳渵渶渷"
        + "渹渻渼渽渿湀湁湂湄湅湆湇湈湉湋湌湍湎湏湐湑湒湓湔湕湗湙湚湜湝浈湟湠湡湢湤湥湦湨湩湪湫湬湭湮湰湱湲湳湴湵"
        + "湶湷湸湹湺湻湼湽満溁溂溄溆溇沩溉溊溋溌溍溎溏溑溒溓溔溕溗溘溙溚溛溞溟溠溡溣溤溥溦溧溨溩溬溭溯溰溱溲涢溴"
        + "溵溶溷溸溹溻溽溾溿滀滁滂滃沧滆滇滈滉滊涤滍荥滏滐滒滓滖滗滘滙滛滜滝滞滟滠滢滣滦滧滪滫沪滭滮滰滱渗滳滵滶"
        + "滹滺浐滼滽漀漃漄漅漈漉溇漋漌漍漎漐漑澙熹漗漘漙沤漛漜漝漞漟漡漤漥漦漧漨漪渍漭漮漯漰漱漳漴溆漶漷漹漺漻漼"
        + "漽漾浆潀颍潂潃潄潅潆潇潈潉潊潋潌潍潎潏潐潒潓洁潕潖潗潘沩潚潜潝潞潟潠潡潢潣润潥潦潧潨潩潪潫潬潭浔溃潱潲"
        + "潳潴潵潶滗潸潹潺潻潼潽潾涠澁澄澃澅浇涝澈澉澊澋澌澍澎澏湃澐澑澒澓澔澕澖涧澘澙澚澛澜澝澞澟渑澢澣泽澥滪澧"
        + "澨澪澫澬澭浍澯澰淀澲澳澴澵澶澷澸澹澺澻澼澽澾澿濂濄濅濆濇濈濉濊濋濌濍濎濏濐濑濒濓沵濖濗泞濙濚濛浕濝濞济"
        + "濠濡濢濣涛濥濦濧濨濩濪滥浚濭濮濯潍滨濲濳濴濵濶濷濸濹溅濻泺濽滤濿瀀漾瀂瀃灋渎瀇瀈泻瀊沈瀌瀍瀎浏瀐瀒瀓瀔"
        + "濒瀖瀗泸瀙瀚瀛瀜瀞潇潆瀡瀢瀣瀤瀥潴泷濑瀩瀪瀫瀬瀭瀮瀯弥瀱潋瀳瀴瀵瀶瀷瀸瀹瀺瀻瀼瀽澜瀿灀灁瀺灂沣滠灅灆灇"
        + "灈灉灊灋灌灍灎灏灐洒灒灓漓灖灗滩灙灚灛灜灏灞灟灠灡灢湾滦灥灦灧灨灪灮灱灲灳灴灷灸灹灺灻灼炀炁炂炃炄炅炆"
        + "炇炈炋炌炍炏炐炑炓炔炕炖炗炘炙炚炛炜炝炞炟炠炡炢炣炤炥炦炧炨炩炪炫炯炰炱炲炳炴炵炶炷炻炽炾炿烀烁烃烄烅"
        + "烆烇烉烊烋烌烍烎烐烑烒烓烔烕烖烗烙烚烜烝烞烠烡烢烣烥烩烪烯烰烱烲烳烃烵烶烷烸烹烺烻烼烾烿焀焁焂焃焄焇焈"
        + "焉焋焌焍焎焏焐焑焒焓焔焕焖焗焘焙焛焜焝焞焟焠焢焣焤焥焧焨焩焪焫焬焭焮焯焱焲焳焴焵焷焸焹焺焻焼焽焾焿煀煁"
        + "煂煃煄煅煇煈炼煊煋煌煍煎煏煐煑炜煓煔暖煗煘煚煛煜煝煞煟煠煡茕煣焕煦煨煪煫炀煭煯煰煱煲煳煴煵煶煷煸煹煺煻"
        + "煼煽煾煿熀熁熂熃熄熅熆熇熈熉熋熌熍熎熏熐熑荧熓熔熕熖炝熘熚熛熜熝熞熠熡熢熣熤熥熦熧熨熩熪熫熬熭熮熯熰颎"
        + "熳熴熵熶熷熸熹熺熻熼熽炽熿燀烨燂燅燆燇炖燊燋燌燍燎燏燐燑燓燔燖燗燘燚燛燝燞燠燡燢燣燤燥灿燧燨燩燪燫燮燯"
        + "燰燱燲燳烩燵燵燸燹燺薰燽焘燿爀爁爂爃爄爅爇爈爉爊爋爌烁爎爏爑爒爓爔爕爖爗爘爙爚烂爜爝爞爟爠爡爢爣爤爥爦"
        + "爧爨爩爮爯爰爳爴舀爷爻爼爽牀牁牂牃牄牅牊牉牋牍牎牏牐牑牒牓牔牕牖牗牚芽牜牝牞牟牣牤牥牦牨牪牫牬牭牮牯牰"
        + "牱牳牴牶牷牸牻牼牾牿犂犃犄犅犆犇犈犉犊犋犌犍犎犏犐犑犒犓犔犕荦犗犘犙犚牦犜犝犞犟犠犡犣犤犥犦牺犨犩犪犫"
        + "犭犰犱犲犳犴犵犷犸犹犺犻犼犽犾犿狘狁狃狄狅狆狇狉狊狋狌狍狎狏狑狒狓狔狕狖狙狚狛狜狝狞狟狡猯狢狣狤狥狦狧"
        + "狨狩狪狫狭狮狯狰狱狲狳狴狵狶狷狭狺狻狾狿猀猁猂猃猄猅猆猇猈猉猊猋猌猍猑猒猓猔猕猗猘狰猚猝猞猟猠猡猢猣猤"
        + "猥猦猧猨猬猭猰猱猲猳猵犹猷猸猹猺狲猼猽猾獀犸獂獆獇獈獉獊獋獌獍獏獐獑獒獓獔獕獖獗獘獙獚獛獜獝獞獟獠獡獢"
        + "獣獤獥獦獧獩狯猃獬獭狝獯狞獱獳獴獶獹獽獾獿猡玁玂玃";

    private static Random random = new Random(new Date().getTime());

    public static String genOneChineseChars() {
        String str = null;
        int highPos = (176 + Math.abs(random.nextInt(39)));
        int lowPos = 161 + Math.abs(random.nextInt(93));
        byte[] b = new byte[] { (new Integer(highPos)).byteValue(),
            (new Integer(lowPos)).byteValue() };

        try {
            str = new String(b, "GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return str;
    }

    public static String genFixedLengthChineseChars(int length) {
        String str = "";
        for (int i = length; i > 0; i--) {
            str = str + genOneChineseChars();
        }

        return str;
    }

    public static String genRandomLengthChineseChars(int start, int end) {
        String str = "";
        int length = random.nextInt(end + 1);
        if (length < start) {
            str = genRandomLengthChineseChars(start, end);
        } else {
            for (int i = 0; i < length; i++) {
                str = str + genOneChineseChars();
            }
        }
        return str;
    }

    public static char getOneOddChar() {
        return ODD_CHINESE_CHARS
            .charAt(random.nextInt(ODD_CHINESE_CHARS.length()));
    }

    public static void main(String args[]) {
        System.out.println(genOneChineseChars());
        System.out.println(genFixedLengthChineseChars(20));
        System.out.println(genRandomLengthChineseChars(2, 10));
    }
}
