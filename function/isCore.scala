package com.zstu.libdata.StreamSplit.function

/**
 * Created by SuHanmo on 2017/6/28.
 * AppName: isCore
 * Function:
 * Input Table:
 * Output Table:
 */
object isCore {
  val coreJournals = Array(

    "actabiochimicaetbiophysicasinica",
    "actageologicasinica",
    "actamathematicaeapplicataesinica",
    "actamathematicascientia",
    "actamathematicasinicaengsers",
    "actamechanicasinica",
    "actaoceanologicasinica",
    "actapharmacologicasinica",
    "actaphysiologicasinica",
    "advancesinatmosphericsciences",
    "algebracolloquium",
    "appliedmathematicsseriesbajournalofchineseuniversities",
    "asianjournalofandrology",
    "biomedicalandenvironmentalscience",
    "biomedicalandenvironmentalsciences",
    "cellresearch",
    "chemicalresearchinchineseuniversities",
    "chinaparticuology",
    "chinawelding",
    "chineseannalsofmathematicsseriesb",
    "chinesechemicalletters",
    "chinesegeographicalscience",
    "chinesejournalofaeronautics",
    "chinesejournalofastronomyandastrophysics",
    "chinesejournalofcancerresearch",
    "chinesejournalofchemicalengineering",
    "chinesejournalofchemicalphysics",
    "chinesejournalofchemistry",
    "chinesejournalofmechanicalengineering",
    "chinesejournalofoceanologyandlimnology",
    "chinesejournalofpolymerscience",
    "chinesejournalofstructuralchemistry",
    "chineseopticsletters",
    "chinesephysics",
    "chinesephysicsb",
    "chinesephysicsc",
    "chinesephysicsletters",
    "communicationsintheoreticalphysics",
    "frontiersofcomputerscienceinchina",
    "frontiersofmaterialsscienceinchina",
    "frontiersofphysicsinchina",
    "genomicsproteomicsbioinformatics",
    "insectscience",
    "journalofbionicsengineering",
    "journalofcomputationalmathematics",
    "journalofcomputerscienceandtechnology",
    "journalofenvironmentalsciences",
    "journalofforestryresearch",
    "journalofgeneticsandgenomics",
    "journalofgeographicalsciences",
    "journalofintegrativeplantbiology",
    "journalofnaturalgaschemistry",
    "journalofsystemsengineeringandelectronics",
    "journalofsystemsscienceandcomplexity",
    "molecularplant",
    "neuralregenerationresearch",
    "northeasternmathematicaljournal",
    "nuclearscienceandtechniques",
    "particuology",
    "pedosphere",
    "plasmasciencetechnology",
    "raremetals",
    "semiconductorphotonicsandtechnology",
    "thejournalofchinauniversitiesofpostsandtelecommunications",
    "transactionsofnonferrousmetalssocietyofchina",
    "virologicasinica",
    "worldjournalofgastroenterology",
    "癌变畸变突变",
    "癌症",
    "安徽大学学报哲学社会科学版",
    "安徽师范大学学报人文社会科学版",
    "安徽史学",
    "安全与环境学报",
    "氨基酸与生物资源",
    "百年潮",
    "班主任",
    "半导体光电",
    "半导体光子学与技术英文版",
    "半导体技术",
    "半导体学报",
    "包装工程",
    "保险理论与实践",
    "保险研究",
    "爆破",
    "爆破器材",
    "爆炸与冲击",
    "北方交通大学学报",
    "北方经济",
    "北方论丛",
    "北方民族大学学报",
    "北方园艺",
    "北京大学教育评论",
    "北京大学学报医学版",
    "北京大学学报医学报",
    "北京大学学报哲学社会科学版",
    "北京大学学报自然科学版",
    "北京档案",
    "北京电影学院学报",
    "北京工商大学学报社会科学版",
    "北京工业大学学报",
    "北京航空航天大学学报",
    "北京交通大学学报社会科学版",
    "北京教育",
    "北京科技大学学报",
    "北京理工大学学报",
    "北京理工大学学报社会科学版",
    "北京林业大学学报",
    "北京商学院学报",
    "北京社会科学",
    "北京师范大学学报人文社会科学版",
    "北京师范大学学报社会科学版",
    "北京师范大学学报自然科学版",
    "北京体育大学学报",
    "北京文学",
    "北京行政学院学报",
    "北京医科大学学报",
    "北京医学",
    "北京邮电大学学报",
    "北京中医药大学学报",
    "逼近论及其应用英文版",
    "比较法研究",
    "比较教育研究",
    "编辑学报",
    "编辑学刊",
    "编辑之友",
    "变压器",
    "表面技术",
    "冰川冻土",
    "兵工学报",
    "兵器材料科学与工程",
    "病毒学报",
    "病毒学杂志",
    "波谱学杂志",
    "玻璃钢复合材料",
    "玻璃与搪瓷",
    "材料保护",
    "材料导报",
    "材料工程",
    "材料科学与工程",
    "材料科学与工程学报",
    "材料科学与工艺",
    "材料热处理学报",
    "材料研究学报",
    "财会通讯",
    "财会研究",
    "财会月刊",
    "财金贸易",
    "财经科学",
    "财经理论与实践",
    "财经论丛",
    "财经论丛浙江财经学院学报",
    "财经问题研究",
    "财经研究",
    "财贸经济",
    "财贸研究",
    "财务与会计",
    "财政研究",
    "蚕桑通报",
    "蚕业科学",
    "草业学报",
    "测绘科技通讯",
    "测绘科学",
    "测绘通报",
    "测绘学报",
    "测井技术",
    "测控技术",
    "茶叶",
    "茶叶科学",
    "产业经济研究",
    "长春科技大学学报",
    "长江科学院院报",
    "长江流域资源与环境",
    "车用发动机",
    "沉积学报",
    "成都理工学院学报",
    "成都体育学院学报",
    "城市发展研究",
    "城市规划",
    "城市规划汇刊",
    "城市规划学刊",
    "城市环境与城市生态",
    "城市问题",
    "出版发行研究",
    "出版科学",
    "传感技术学报",
    "传感器技术",
    "传感器与微系统",
    "船舶",
    "船舶工程",
    "辞书研究",
    "磁性材料与器件",
    "催化学报",
    "大地测量与地球动力学",
    "大地构造与成矿学",
    "大电机技术",
    "大豆科学",
    "大家",
    "大连海事大学学报",
    "大连理工大学学报",
    "大连理工大学学报社会科学版",
    "大连水产学院学报",
    "大气科学",
    "大庆石油学院学报",
    "大学出版",
    "大学国书馆学报",
    "大学教育科学",
    "大学图书馆学报",
    "大学物理",
    "弹道学报",
    "弹箭与制导学报",
    "淡水渔业",
    "当代",
    "当代财经",
    "当代传播",
    "当代电视",
    "当代电影",
    "当代法学",
    "当代经济科学",
    "当代经济研究",
    "当代青年研究",
    "当代世界",
    "当代世界社会主义问题",
    "当代世界与社会主义",
    "当代思潮",
    "当代外国文学",
    "当代文坛",
    "当代戏剧",
    "当代亚太",
    "当代语言学",
    "当代中国史研究",
    "当代宗教研究",
    "当代作家评论",
    "党的文献",
    "党建",
    "党建研究",
    "党史研究与教学",
    "党政论坛",
    "档案",
    "档案管理",
    "档案学通讯",
    "档案学研究",
    "档案与建设",
    "导弹与航天运载技术",
    "道德与文明",
    "德国研究",
    "低温工程",
    "低温物理学报",
    "低温与超导",
    "地层学杂志",
    "地理科学",
    "地理科学进展",
    "地理学报",
    "地理学与国土研究",
    "地理研究",
    "地球化学",
    "地球科学",
    "地球科学进展",
    "地球物理学报",
    "地球物理学进展",
    "地球学报",
    "地球与环境",
    "地图",
    "地学前缘",
    "地域研究与开发",
    "地震",
    "地震地质",
    "地震工程与工程振动",
    "地震学报",
    "地震研究",
    "地质地球化学",
    "地质科技情报",
    "地质科学",
    "地质论评",
    "地质通报",
    "地质学报",
    "地质与勘探",
    "第二军医大学学报",
    "第三军医大学学报",
    "第四纪研究",
    "第四军医大学学报",
    "第一军医大学学报",
    "电波科学学报",
    "电测与仪表",
    "电池",
    "电瓷避雷器",
    "电镀与环保",
    "电镀与涂饰",
    "电工电能新技术",
    "电工技术学报",
    "电工能源新技术",
    "电化教育研究",
    "电化学",
    "电机与控制学报",
    "电加工",
    "电力电子技术",
    "电力建设",
    "电力系统及其自动化学报",
    "电力系统自动化",
    "电力自动化设备",
    "电路与系统学报",
    "电气传动",
    "电气自动化",
    "电声技术",
    "电视技术",
    "电视研究",
    "电网技术",
    "电线电缆",
    "电信科学",
    "电汛技术",
    "电影创作",
    "电影通讯",
    "电影文学",
    "电影新作",
    "电影艺术",
    "电源技术",
    "电站系统工程",
    "电子测量与仪器学报",
    "电子技术应用",
    "电子科技大学学报",
    "电子器件",
    "电子显微学报",
    "电子学报",
    "电子与信息学报",
    "电子元件与材料",
    "电子知识产权",
    "东北大学学报社会科学版",
    "东北大学学报自然科学版",
    "东北林业大学学报",
    "东北师大学报哲社版",
    "东北师大学报哲学社会科学版",
    "东北师大学报自然科学版",
    "东北亚论坛",
    "东华大学学报自然科学版",
    "东疆学刊",
    "东南大学学报",
    "东南大学学报哲学社会科学版",
    "东南大学学报自然科学版",
    "东南文化",
    "东南学术",
    "东南亚研究",
    "东欧中亚研究",
    "东岳论丛",
    "动力工程",
    "动物分类学报",
    "动物学报",
    "动物学研究",
    "动物学杂志",
    "动物营养学报",
    "读书",
    "锻压机械",
    "锻压技术",
    "对外经贸实务",
    "敦煌学辑刊",
    "敦煌研究",
    "俄罗斯文艺",
    "俄罗斯研究",
    "俄罗斯中亚东欧研究",
    "儿童文学",
    "耳鼻咽喉头颈外科杂志",
    "发光学报",
    "法国研究",
    "法律科学",
    "法律科学西北政法大学学报",
    "法商研究",
    "法学",
    "法学家",
    "法学论坛",
    "法学评论",
    "法学研究",
    "法学杂志",
    "法音",
    "法制与社会发展",
    "犯罪与改造研究",
    "方言",
    "纺织学报",
    "飞行力学",
    "非金属矿",
    "分析测试学报",
    "分析化学",
    "分析科学学报",
    "分析试验室",
    "分子催化",
    "分子细胞生物学报",
    "粉末冶金技术",
    "风机技术",
    "福建林学院学报",
    "福建论坛经济社会版",
    "福建论坛人文社会科学版",
    "福建农林大学学报自然科学版",
    "福建农业大学学报",
    "福建师范大学学报哲学社会科学版",
    "福州大学学报哲学社会科学版",
    "辐射防护",
    "辐射研究与辐射工艺学报",
    "腐蚀科学与防护技术",
    "妇女研究论丛",
    "复旦大学学报社会科学版",
    "复旦大学学报自然科学版",
    "复旦教育论坛",
    "复旦学报社会科学版",
    "复旦学报医学版",
    "复旦学报医学版原名上海医科大学学报",
    "复旦学报自然科学版",
    "复合材料学报",
    "改革",
    "改革与战略",
    "干旱地区农业研究",
    "干旱区地理",
    "干旱区研究",
    "干旱区资源与环境",
    "甘肃工业大学学报",
    "甘肃社会科学",
    "甘肃政法学院学报",
    "感光科学与光化学",
    "钢铁",
    "钢铁钒钛",
    "钢铁研究学报",
    "港澳经济",
    "港工技术",
    "高等工程教育研究",
    "高等工程教育研究武汉",
    "高等教育研究",
    "高等教育研究武汉",
    "高等理科教育",
    "高等农业教育",
    "高等师范教育研究",
    "高等学校化学学报",
    "高等学校计算数学学报",
    "高电压技术",
    "高分子材料科学与工程",
    "高分子通报",
    "高分子学报",
    "高技术通讯",
    "高教发展与评估",
    "高教探索",
    "高能物理与核物理",
    "高校地质学报",
    "高校化学工程学报",
    "高校理论战线",
    "高校应用数学学报",
    "高血压杂志",
    "高压电器",
    "高压物理学报",
    "高原气象",
    "歌剧艺术研究",
    "给水排水",
    "工程地质学报",
    "工程机械",
    "工程勘察",
    "工程力学",
    "工程热物理学报",
    "工程设计学报",
    "工程数学学报",
    "工程塑料应用",
    "工程图学学报",
    "工会理论与实践",
    "工具技术",
    "工业工程与管理",
    "工业技术经济",
    "工业建筑",
    "工业水处理",
    "工业微生物",
    "工业卫生与职业病",
    "工业仪表与自动化装置",
    "公安大学学报",
    "公共管理学报",
    "公共行政评论",
    "公路",
    "公路交通科技",
    "功能材料",
    "功能材料与器件学报",
    "功能高分子学报",
    "古汉语研究",
    "古籍整理与研究学刊",
    "古脊椎动物学报",
    "古生物学报",
    "固体电子学研究与进展",
    "固体火箭技术",
    "固体力学学报",
    "故宫博物院院刊",
    "管理工程学报",
    "管理科学",
    "管理科学学报",
    "管理评论",
    "管理世界",
    "管理现代化",
    "管理信息系统",
    "管理学报",
    "管子学刊",
    "灌溉排水",
    "光电工程",
    "光电子激光",
    "光电子技术",
    "光谱实验室",
    "光谱学与光谱分析",
    "光通信技术",
    "光通信研究",
    "光学技术",
    "光学精密工程",
    "光学学报",
    "光学仪器",
    "光子学报",
    "广播与电视技术",
    "广东金融",
    "广东金融学院学报",
    "广东社会科学",
    "广东微量元素科学",
    "广东医药",
    "广东造纸",
    "广西会计",
    "广西民族大学学报哲学社会科学版",
    "广西民族学院学报哲学社会科学版",
    "广西民族研究",
    "广西农业生物技术",
    "广西植物",
    "广州体育学院学报",
    "硅酸盐通报",
    "硅酸盐学报",
    "贵金属",
    "贵州民族研究",
    "贵州社会科学",
    "锅炉技术",
    "国防科技大学学报",
    "国际肝胆胰疾病杂志英文版",
    "国际观察",
    "国际广告",
    "国际金融",
    "国际金融研究",
    "国际经济合作",
    "国际经济评论",
    "国际经贸探索",
    "国际论坛",
    "国际贸易",
    "国际贸易问题",
    "国际商务",
    "国际商务对外经济贸易大学学报",
    "国际商务研究",
    "国际问题研究",
    "国际新闻界",
    "国际政治研究",
    "国家教育行政学院学报",
    "国家图书馆学刊",
    "国家行政学院学报",
    "国土资源遥感",
    "国外理论动态",
    "国外社会科学",
    "国外外语教学",
    "国外文学",
    "国有资产管理",
    "果树学报",
    "果树学报原果树科学",
    "过程工程学报",
    "哈尔滨工业大学学报",
    "哈尔滨建筑大学学报",
    "哈尔滨医科大学学报",
    "海南大学学报人文社会科学版",
    "海洋地质与第四纪地质",
    "海洋工程",
    "海洋环境科学",
    "海洋技术",
    "海洋科学",
    "海洋水产研究",
    "海洋通报",
    "海洋学报",
    "海洋与湖沼",
    "海洋预报",
    "含能材料",
    "汉语学报",
    "汉语学习",
    "汉字文化",
    "焊接学报",
    "航海技术",
    "航空材料学报",
    "航空动力学报",
    "航空工艺技术",
    "航空精密制造技术",
    "航空学报",
    "航空制造工程",
    "航天控制",
    "航天医学与医学工程",
    "合成化学",
    "合成纤维",
    "合成纤维工业",
    "合成橡胶工业",
    "和平与发展",
    "河北大学学报哲学社会科学版",
    "河北法学",
    "河北经贸大学学报",
    "河北农业大学学报",
    "河北学刊",
    "河海大学学报",
    "河海大学学报自然科学版",
    "河南大学学报社会科学版",
    "河南社会科学",
    "河南师范大学学报哲学社会科学版",
    "核电子学与探测技术",
    "核动力工程",
    "核化学与放射化学",
    "核技术",
    "核聚变与等离子体物理",
    "核科学与工程",
    "核农学报",
    "黑龙江高教研究",
    "黑龙江民族丛刊",
    "黑龙江畜牧兽医",
    "红楼梦学刊",
    "红外技术",
    "红外与毫米波学报",
    "红外与激光工程",
    "宏观经济管理",
    "宏观经济研究",
    "湖北财政研究",
    "湖北大学学报哲学社会科学版",
    "湖泊科学",
    "湖南大学学报社会科学版",
    "湖南大学学报自然科学版",
    "湖南社会科学",
    "湖南师范大学社会科学学报",
    "湖南师范大学自然科学学报",
    "湖南医科大学学报",
    "护理与康复",
    "护士进修杂志",
    "花城",
    "华北电力大学学报",
    "华北电力技术",
    "华北农学报",
    "华东电力",
    "华东工业大学学报",
    "华东公路",
    "华东经济管理",
    "华东理工大学学报",
    "华东理工大学学报社会科学版",
    "华东理工大学学报自然科学版",
    "华东师范大学学报教科版",
    "华东师范大学学报教育科学版",
    "华东师范大学学报哲学社会科学版",
    "华东师范大学学报自然科学版",
    "华东政法大学学报",
    "华东政法学院学报",
    "华南理工大学学报自然科学版",
    "华南农业大学学报",
    "华南农业大学学报社会科学版",
    "华南农业大学学报自然科学版",
    "华南师范大学学报社会科学版",
    "华侨华人历史研究",
    "华西口腔医学杂志",
    "华西医科大学学报",
    "华夏考古",
    "华中建筑",
    "华中科技大学学报",
    "华中科技大学学报社会科学版",
    "华中科技大学学报医学版",
    "华中科技大学学报自然科学版",
    "华中农业大学学报",
    "华中师范大学学报人文社会科学版",
    "华中师范大学学报哲学社会科学版",
    "华中师范大学学报自然科学版",
    "化工环保",
    "化工进展",
    "化工矿物与加工",
    "化工新型材料",
    "化工学报",
    "化工冶金",
    "化工自动化及仪表",
    "化学反应工程与工艺",
    "化学工程",
    "化学建材",
    "化学教学",
    "化学进展",
    "化学世界",
    "化学试剂",
    "化学通报",
    "化学物理学报",
    "化学学报",
    "化学研究与应用",
    "环境保护",
    "环境工程",
    "环境工程学报",
    "环境化学",
    "环境科学",
    "环境科学学报",
    "环境科学研究",
    "环境污染与防治",
    "环境污染治理技术与设备",
    "环境与健康杂志",
    "环境与职业医学",
    "环球法律评论",
    "黄渤海海洋",
    "黄钟",
    "黄钟武汉音乐学院学报",
    "回族研究",
    "会计研究",
    "混凝土",
    "混凝土与水泥制品",
    "火工品",
    "火力与指挥控制",
    "火炮发射与控制学报",
    "火灾科学",
    "火炸药学报",
    "机车电传动",
    "机床与液压",
    "机电工程",
    "机器人",
    "机械传动",
    "机械工程材料",
    "机械工程学报",
    "机械工艺师",
    "机械科学与技术",
    "机械科学与技术西安",
    "机械强度",
    "机械设计",
    "机械设计与研究",
    "机械设计与制造工程",
    "机械制造",
    "基础医学与临床",
    "激光技术",
    "激光生物学报",
    "激光与红外",
    "激光杂志",
    "吉林大学社会科学学报",
    "吉林大学学报地球科学版",
    "吉林大学学报理学版",
    "吉林大学学报医学版",
    "吉林大学自然科学学报",
    "吉林工业大学自然科学学报",
    "吉林教育科学高教研究",
    "极地研究",
    "集团经济研究",
    "计量学报",
    "计算机仿真",
    "计算机辅助设计与图形学学报",
    "计算机工程",
    "计算机工程与科学",
    "计算机工程与应用",
    "计算机集成制造系统",
    "计算机科学",
    "计算机科学技术学报英文版",
    "计算机系统应用",
    "计算机学报",
    "计算机研究与发展",
    "计算机应用",
    "计算机应用研究",
    "计算机应用与软件",
    "计算机与应用化学",
    "计算机自动测量与控制",
    "计算力学学报",
    "计算数学",
    "计算物理",
    "继电器",
    "暨南大学华文学院学报",
    "暨南学报哲学社会科学版",
    "家畜生态",
    "价格理论与实践",
    "价格月刊",
    "检验医学",
    "建井技术",
    "建筑材料学报",
    "建筑机械",
    "建筑技术",
    "建筑结构",
    "建筑结构学报",
    "建筑经济",
    "建筑学报",
    "舰船科学技术",
    "江海学刊",
    "江汉考古",
    "江汉论坛",
    "江汉石油学院学报",
    "江淮论坛",
    "江苏高教",
    "江苏经济探讨",
    "江苏农村经济",
    "江苏农业科学",
    "江苏农业学报",
    "江苏社会科学",
    "江苏行政学院学报",
    "江苏医药",
    "江西财经大学学报",
    "江西农业经济",
    "江西社会科学",
    "交响西安音乐学院学报",
    "教师教育研究",
    "教学与研究",
    "教育财会研究",
    "教育发展研究",
    "教育科学",
    "教育理论与实践",
    "教育评论",
    "教育探索",
    "教育信息化2007年更名为中国教育信息化学术版",
    "教育学报",
    "教育研究",
    "教育研究与实验",
    "教育与经济",
    "教育与现代化",
    "教育与职业",
    "节水灌溉",
    "结构化学",
    "解放军测绘学院学报",
    "解放军外国语学院学报",
    "解放军外语学院学报",
    "解放军文艺",
    "解放军医学杂志",
    "解放军预防医学杂志",
    "解剖学报",
    "解剖学杂志",
    "金融管理科学",
    "金融理论与实践",
    "金融论坛",
    "金融研究",
    "金融与经济",
    "金属矿山",
    "金属热处理",
    "金属热处理学报",
    "金属学报",
    "近代史研究",
    "晋阳学刊",
    "经济导刊",
    "经济地理",
    "经济改革",
    "经济管理",
    "经济经纬",
    "经济科学",
    "经济理论与经济管理",
    "经济论坛",
    "经济评论",
    "经济社会体制比较",
    "经济体制改革",
    "经济问题",
    "经济问题探索",
    "经济学动态",
    "经济学季刊",
    "经济学家",
    "经济研究",
    "经济与管理研究",
    "经济与信息",
    "经济纵横",
    "经营与管理",
    "精细化工",
    "精细石油化工",
    "剧本",
    "绝缘材料通讯",
    "军事史林",
    "军事医学科学院院刊",
    "菌物学报",
    "菌物学报原菌物系统",
    "开发研究",
    "开放教育研究",
    "开放时代",
    "抗日战争研究",
    "考古",
    "考古学报",
    "考古与文物",
    "科技管理研究",
    "科技进步与对策",
    "科技通报",
    "科技与出版",
    "科技与经济",
    "科学对社会的影响",
    "科学管理研究",
    "科学技术与辩证法",
    "科学技术哲学研究原科学技术与辩证法",
    "科学经济社会",
    "科学社会主义",
    "科学通报",
    "科学学研究",
    "科学学与科学技术管理",
    "科学与社会",
    "科研管理",
    "课程教材教法",
    "空间结构",
    "空间科学学报",
    "空气动力学学报",
    "孔子研究",
    "控制工程",
    "控制理论与应用",
    "控制与决策",
    "口腔颌面部外科杂志",
    "口腔医学",
    "矿床地质",
    "矿山机械",
    "矿物学报",
    "矿物岩石",
    "矿冶工程",
    "昆虫分类学报",
    "昆虫天敌",
    "昆虫学报",
    "昆虫知识",
    "拉丁美洲研究",
    "兰台世界",
    "兰州大学学报社会科学版",
    "兰州大学学报自然科学版",
    "劳动医学",
    "离子交换与吸附",
    "理化检验化学分册",
    "理论导刊",
    "理论前沿",
    "理论视野",
    "理论探索",
    "理论探讨",
    "理论学刊",
    "理论与改革",
    "力学季刊",
    "力学进展",
    "力学学报",
    "力学与实践",
    "历史档案",
    "历史教学",
    "历史教学问题",
    "历史研究",
    "炼钢",
    "炼铁",
    "炼油设计",
    "粮油食品科技",
    "量子电子学报",
    "量子光学学报",
    "辽宁高等教育研究",
    "林产工业",
    "林产化学与工业",
    "林业机械与木工设备",
    "林业经济",
    "林业科技",
    "林业科技通讯",
    "林业科学",
    "林业科学研究",
    "林业资源管理",
    "临床儿科杂志",
    "临床耳鼻咽喉科杂志",
    "临床放射学杂志",
    "临床肝胆病杂志",
    "临床荟萃",
    "临床检验杂志",
    "临床麻醉学杂志",
    "临床内科杂志",
    "临床皮肤科杂志",
    "临床心血管病杂志",
    "临床与实验病理学杂志",
    "流体机械",
    "流体力学试验与测量",
    "鲁迅研究月刊",
    "旅游科学",
    "旅游科学上海旅游高等专科学校学报",
    "旅游学刊",
    "伦理学研究",
    "马克思主义研究",
    "马克思主义与现实",
    "麦类作物学报",
    "满族研究",
    "毛纺科技",
    "毛泽东邓小平理论研究",
    "毛泽东思想研究",
    "煤矿安全",
    "煤矿机电",
    "煤矿机械",
    "煤矿设计",
    "煤矿自动化",
    "煤炭经济研究",
    "煤炭科学技术",
    "煤炭学报",
    "煤炭转化",
    "煤田地质与勘探",
    "美国研究",
    "美术",
    "美术观察",
    "美术史论",
    "美术研究",
    "棉纺织技术",
    "棉花学报",
    "免疫学杂志",
    "民国档案",
    "民间文学",
    "民俗研究",
    "民族论坛",
    "民族文学",
    "民族文学研究",
    "民族研究",
    "民族艺术",
    "民族艺术研究",
    "民族语文",
    "名作欣赏",
    "明清小说研究",
    "模糊系统与数学",
    "模具工业",
    "模式识别与人工智能",
    "膜科学与技术",
    "摩擦学学报",
    "木本植物研究",
    "木材工业",
    "内蒙古大学学报人文社会科学版",
    "内蒙古大学学报自然科学版",
    "内蒙古社会科学",
    "内蒙古社会科学文史哲版",
    "内燃机车",
    "内燃机工程",
    "内燃机学报",
    "耐火材料",
    "南昌大学学报哲学社会科学版",
    "南方经济",
    "南方农村",
    "南方人口",
    "南方文坛",
    "南方医科大学学报",
    "南京大学学报哲学人文科学社会科学",
    "南京大学学报哲学人文科学社会科学版",
    "南京大学学报自然科学版",
    "南京航空航天大学学报",
    "南京理工大学学报",
    "南京林业大学学报",
    "南京农业大学学报",
    "南京农业大学学报社会科学版",
    "南京气象学院学报",
    "南京社会科学",
    "南京师大学报社会科学版",
    "南京师范大学社会科学版",
    "南京师范大学文学院学报",
    "南京医科大学学报自然科学版",
    "南京艺术学院学报音乐与表演版",
    "南开大学学报自然科学版",
    "南开管理评论",
    "南开经济研究",
    "南开学报哲学社会科学版",
    "南亚研究",
    "南亚研究季刊",
    "南洋问题研究",
    "泥沙研究",
    "酿酒",
    "宁夏大学学报人文社会科学版",
    "宁夏社会科学",
    "农场经济管理",
    "农村成人教育",
    "农村电气化",
    "农村合作经济经营管理",
    "农村金融研究",
    "农村经济",
    "农村经济导刊",
    "农村能源",
    "农村生态环境",
    "农机化研究",
    "农田水利与小水电",
    "农药",
    "农药学报",
    "农药学学报",
    "农业工程学报",
    "农业环境保护",
    "农业环境科学学报",
    "农业机械学报",
    "农业技术经济",
    "农业经济",
    "农业经济问题",
    "农业科技通讯",
    "农业生物技术学报",
    "农业系统科学与综合研究",
    "农业现代化研究",
    "暖通空调",
    "欧洲",
    "欧洲研究",
    "普教研究",
    "齐鲁学刊",
    "企业管理",
    "企业活力",
    "企业经济",
    "起重运输机械",
    "气候与环境研究",
    "气象",
    "气象科技",
    "气象科学",
    "气象学报",
    "汽车工程",
    "汽车技术",
    "汽轮机技术",
    "强激光与粒子束",
    "桥梁建设",
    "青岛海洋大学学报",
    "青海民族研究",
    "青海社会科学",
    "青年文学",
    "青年研究",
    "轻工机械",
    "轻合金加工技术",
    "轻金属",
    "清华大学教育研究",
    "清华大学学报英文版",
    "清华大学学报哲学社会科学版",
    "清华大学学报自然科学版",
    "清华法学",
    "清明",
    "清史研究",
    "情报科学",
    "情报理论与实践",
    "情报学报",
    "情报杂志",
    "情报资料工作",
    "求实",
    "求是",
    "求是学刊",
    "求索",
    "全科医学临床与教育",
    "全球教育展望",
    "燃料化学学报",
    "燃气轮机技术",
    "燃烧科学与技术",
    "热带海洋",
    "热带海洋学报",
    "热带气象学报",
    "热带亚热带植物学报",
    "热带作物学报",
    "热加工工艺",
    "热力发电",
    "热能动力工程",
    "人才",
    "人才开发",
    "人工晶体学报",
    "人口学刊",
    "人口研究",
    "人口与发展原市场与人口分析",
    "人口与计划生育",
    "人口与经济",
    "人类工效学",
    "人类学学报",
    "人民长江",
    "人民黄河",
    "人民检察",
    "人民教育",
    "人民司法",
    "人民文学",
    "人民音乐",
    "人文地理",
    "人文杂志",
    "日本学刊",
    "日用化学工业",
    "日语学习与研究",
    "软件学报",
    "软科学",
    "润滑与密封",
    "散文",
    "色谱",
    "森林病虫通讯",
    "森林工程",
    "山地学报",
    "山东大学学报理学版",
    "山东大学学报医学版",
    "山东大学学报哲学社会科学版",
    "山东大学学报自然科学版",
    "山东教育科研",
    "山东农业大学学报",
    "山东社会科学",
    "山东师大学报社会科学版",
    "山西财经大学学报",
    "山西大学学报哲学社会科学版",
    "山西档案",
    "陕西师范大学学报哲学社会科学版",
    "陕西师范大学学报自然科学版",
    "商场现代化",
    "商业经济文荟",
    "商业经济研究",
    "商业经济与管理",
    "商业研究",
    "上海保险",
    "上海财经大学学报",
    "上海财经大学学报哲学社会科学版",
    "上海财税",
    "上海成人教育",
    "上海大学学报社会科学版",
    "上海档案",
    "上海第二医科大学学报",
    "上海纺织科技",
    "上海环境科学",
    "上海会计",
    "上海交通大学学报",
    "上海交通大学学报工学版",
    "上海交通大学学报医学版",
    "上海交通大学学报英文版",
    "上海交通大学学报哲学社会科学版",
    "上海教育",
    "上海教育科研",
    "上海金融",
    "上海经济研究",
    "上海精神医学",
    "上海科技翻译",
    "上海免疫学杂志",
    "上海农业学报",
    "上海企业",
    "上海社会科学院学术季刊",
    "上海师范大学学报哲学社会科学版",
    "上海水产大学学报",
    "上海体育学院学报",
    "上海天文台年刊",
    "上海统计",
    "上海文学",
    "上海行政学院学报",
    "上海医科大学学报",
    "上海医学",
    "上海医学检验杂志",
    "上海中医药杂志",
    "烧结球团",
    "社会",
    "社会科学",
    "社会科学辑刊",
    "社会科学家",
    "社会科学研究",
    "社会科学战线",
    "社会社会学丛刊",
    "社会学研究",
    "社会主义研究",
    "涉外税务",
    "深冷技术",
    "深圳大学学报人文社会科学版",
    "深圳大学学报人文社科版",
    "神经解剖学杂志",
    "沈阳农业大学学报",
    "沈阳药科大学学报",
    "审计理论与实践",
    "审计研究",
    "审计与经济研究",
    "肾脏病透析肾移植杂志",
    "肾脏病与透析肾移植杂志",
    "生产力研究",
    "生理科学进展",
    "生理学报",
    "生命的化学",
    "生命科学",
    "生命科学研究",
    "生态经济",
    "生态农业研究",
    "生态学报",
    "生态学杂志",
    "生态与农村环境学报",
    "生物多样性",
    "生物工程学报",
    "生物化学与生物物理进展",
    "生物化学与生物物理学报",
    "生物技术",
    "生物技术通报",
    "生物加工过程",
    "生物数学学报",
    "生物物理学报",
    "生物信息学",
    "生物学通报",
    "生物医学工程学杂志",
    "生物医学和环境科学英文版",
    "生殖与避孕",
    "声学学报",
    "诗刊",
    "施工技术",
    "湿地科学",
    "十月",
    "石油大学学报自然科学版",
    "石油地球物理勘探",
    "石油工程建设",
    "石油化工",
    "石油化工自动化",
    "石油机械",
    "石油勘探与开发",
    "石油矿场机械",
    "石油炼制与化工",
    "石油实验地质",
    "石油物探",
    "石油学报",
    "石油学报石油加工",
    "石油与天然气地质",
    "石油与天然气化工",
    "石油钻采工艺",
    "实验技术与管理",
    "实验技术与管理限实验技术职称评审用",
    "实验力学",
    "实验流体力学",
    "实验生物学报",
    "实验室研究与探索",
    "实验室研究与探索限实验技术职称评审用",
    "实用儿科临床杂志",
    "实用放射学杂志",
    "实用妇产科杂志",
    "实用护理杂志",
    "实用口腔医学杂志",
    "实用中西医结合杂志",
    "实用肿瘤杂志",
    "食品工业",
    "食品工业科技",
    "食品科技",
    "食品科学",
    "食品与发酵工业",
    "食品与生物技术学报",
    "史林",
    "史学集刊",
    "史学理论研究",
    "史学史研究",
    "史学月刊",
    "世界电影",
    "世界汉语教学",
    "世界华人消化杂志",
    "世界建筑",
    "世界经济",
    "世界经济文汇",
    "世界经济研究",
    "世界经济与政治",
    "世界经济与政治论坛",
    "世界科技研究与发展",
    "世界历史",
    "世界林业研究",
    "世界美术",
    "世界民族",
    "世界农业",
    "世界胃肠病杂志英文版",
    "世界文学",
    "世界哲学",
    "世界知识",
    "世界宗教文化",
    "世界宗教研究",
    "市场与人口分析",
    "收获",
    "首都师范大学学报社会科学版",
    "兽类学报",
    "书法研究",
    "数据采集与处理",
    "数理统计与管理",
    "数理统计与应用概率",
    "数量经济技术经济研究",
    "数学的实践与认识",
    "数学进展",
    "数学年刊ab辑",
    "数学年刊a辑",
    "数学年刊b辑",
    "数学物理学报",
    "数学学报",
    "数学研究与评论",
    "数学杂志",
    "数值计算与计算机应用",
    "水泵技术",
    "水产科学",
    "水产学报",
    "水处理技术",
    "水动力学研究与进展a辑",
    "水动力学研究与进展英文版",
    "水科学进展",
    "水力发电",
    "水力发电学报",
    "水利水电技术",
    "水利水运科学研究",
    "水利学报",
    "水利渔业",
    "水生生物学报",
    "水土保持通报",
    "水土保持学报",
    "水土保持研究",
    "水文",
    "水文地质工程地质",
    "水运工程",
    "税收与企业",
    "税务研究",
    "税务与经济",
    "税务与经济长春税务学院学报",
    "丝绸",
    "思想教育研究",
    "思想理论教育导刊",
    "思想战线",
    "思想政治工作研究",
    "思想政治课教学",
    "四川大学学报工程科学版",
    "四川大学学报医学版",
    "四川大学学报哲学社会科学版",
    "四川大学学报自然科学版",
    "四川动物",
    "四川会计",
    "四川师范大学学报社会科学版",
    "饲料工业",
    "饲料研究",
    "苏州大学学报哲学社会科学版",
    "塑料工业",
    "塑性工程学报",
    "台湾海峡",
    "台湾研究",
    "台湾研究集刊",
    "太平洋学报",
    "太阳能学报",
    "炭素",
    "探测与控制学报",
    "探索",
    "探索与争鸣",
    "特区经济",
    "特区理论与实践",
    "特殊钢",
    "特种铸造及有色合金",
    "体育科学",
    "体育文化导刊",
    "体育文史",
    "体育学刊",
    "体育与科学",
    "天风",
    "天府新论",
    "天津大学学报",
    "天津大学学报社会科学版",
    "天津大学学报自然科学与工程技术版",
    "天津教育",
    "天津社会科学",
    "天津师范大学学报社会科学版",
    "天津体育学院学报",
    "天津医药",
    "天津音乐学院学报",
    "天然产物研究与开发",
    "天然气工业",
    "天然气化工c1化学与工业",
    "天然气化工c1化学与化工",
    "天体物理学报",
    "天文学报",
    "天文学进展",
    "天文研究与技术",
    "天涯",
    "铁道标准设计",
    "铁道建筑",
    "铁道通信信号",
    "铁道学报",
    "铁道运输与经济",
    "铁合金",
    "通俗文学评论",
    "通信学报",
    "同济大学学报社会科学版",
    "同济大学学报自然科学版",
    "同济医科大学学报",
    "统计研究",
    "统计与决策",
    "统计与决策理论版",
    "统计与信息论坛",
    "投资研究",
    "图书发行研究",
    "图书馆",
    "图书馆工作与研究",
    "图书馆建设",
    "图书馆理论与实践",
    "图书馆论坛",
    "图书馆杂志",
    "图书情报工作",
    "图书情报知识",
    "图书与情报",
    "涂料工业",
    "土木工程学报",
    "土木建筑与环境工程原重庆建筑大学学报",
    "土壤",
    "土壤肥料",
    "土壤通报",
    "土壤学报",
    "土壤与环境",
    "推进技术",
    "拖拉机与农用运输车",
    "外国教育研究",
    "外国教育资料",
    "外国经济与管理",
    "外国文学",
    "外国文学动态",
    "外国文学评论",
    "外国文学研究",
    "外国语",
    "外国中小学教育",
    "外交评论外交学院学报",
    "外交学院学报",
    "外语电化教学",
    "外语教学",
    "外语教学理论与实践",
    "外语教学与研究",
    "外语界",
    "外语学刊",
    "外语研究",
    "外语与外语教学",
    "微波学报",
    "微电机",
    "微电子学",
    "微电子学与计算机",
    "微生物学报",
    "微生物学通报",
    "微特电机",
    "微体古生物学报",
    "微型计算机",
    "卫生毒理学杂志",
    "卫生经济研究",
    "卫生研究",
    "未来与发展",
    "文博",
    "文化遗产",
    "文史哲",
    "文史知识",
    "文史中华书局",
    "文物",
    "文献",
    "文学评论",
    "文学遗产",
    "文学自由谈",
    "文艺理论研究",
    "文艺理论与批评",
    "文艺研究",
    "文艺争鸣",
    "无机材料学报",
    "无机化学学报",
    "无锡轻工大学学报",
    "武汉测绘科技大学学报",
    "武汉大学学报理学版",
    "武汉大学学报人文科学版",
    "武汉大学学报社会科学版",
    "武汉大学学报信息科学版",
    "武汉大学学报哲学社会科学版",
    "武汉大学学报自然科学版",
    "武汉交通科技大学学报",
    "武汉水利电力大学学报",
    "武汉体育学院学报",
    "武汉植物学研究",
    "舞蹈",
    "物理",
    "物理化学学报",
    "物理教学",
    "物理实验",
    "物理学报",
    "物理学进展",
    "物探化探计算技术",
    "物探与化探",
    "西安电子科技大学学报",
    "西安公路交通大学学报",
    "西安交通大学报自然科学版",
    "西安交通大学学报社会科学版",
    "西安交通大学学报医学报",
    "西安交通大学学报自然科学版",
    "西安体育学院学报",
    "西北大学学报哲学社会科学版",
    "西北大学学报自然科学版",
    "西北地震学报",
    "西北工业大学学报",
    "西北民族研究",
    "西北农林科技大学学报",
    "西北农林科技大学学报社会科学版",
    "西北农林科技大学学报自然科学版",
    "西北人口",
    "西北师大学报社会科学版",
    "西北植物学报",
    "西藏大学学报社会科学版",
    "西藏研究",
    "西南大学学报人文社会科学版",
    "西南大学学报社会科学版",
    "西南交通大学学报",
    "西南民族大学学报人文社科版",
    "西南民族学院学报哲学社会科学版",
    "西南农林大学学报",
    "西亚非洲",
    "西域研究",
    "稀土",
    "稀有金属",
    "稀有金属材料与工程",
    "戏剧",
    "戏剧艺术",
    "戏剧艺术上海戏剧学院学报",
    "戏剧中央戏剧学院学报",
    "戏曲艺术",
    "系统仿真学报",
    "系统工程",
    "系统工程理论方法应用",
    "系统工程理论与实践",
    "系统工程学报",
    "系统工程与电子技术",
    "系统工程与电子技术英文版",
    "系统管理学报",
    "系统科学学报",
    "系统科学与数学",
    "细胞生物学杂志",
    "细胞研究英文版",
    "细胞与分子免疫学杂志",
    "厦门大学学报哲学社会科学版",
    "厦门大学学报自然科学版",
    "厦门水产学院学报",
    "纤维素科学与技术",
    "现代财经",
    "现代财经天津财经学院学报",
    "现代出版",
    "现代传播",
    "现代传播中国传媒大学学报",
    "现代大学教育",
    "现代地质",
    "现代法学",
    "现代妇产科进展",
    "现代广告",
    "现代国际关系",
    "现代化工",
    "现代教育技术",
    "现代教育论丛",
    "现代经济探讨",
    "现代口腔医学杂志",
    "现代雷达",
    "现代免疫学",
    "现代企业导刊",
    "现代日本经济",
    "现代图书情报技术",
    "现代外语",
    "现代营销",
    "现代远程教育研究",
    "现代远距离教育",
    "现代哲学",
    "现代铸铁",
    "乡镇经济",
    "湘潭大学学报哲学社会科学版",
    "橡胶工业",
    "消费经济",
    "小说评论",
    "小说月报",
    "小型内燃机",
    "小型微型计算机系统",
    "心电学杂志",
    "心理发展与教育",
    "心理科学",
    "心理科学进展",
    "心理学报",
    "心理学动态",
    "心理学探新",
    "心理与行为研究",
    "心血管病防治",
    "新华文摘",
    "新技术新工艺",
    "新建筑",
    "新疆大学学报哲学人文社会科学版",
    "新疆大学学报哲学社会科",
    "新疆社会科学",
    "新疆师范大学学报哲学社会科学版",
    "新疆石油地质",
    "新疆新闻界",
    "新美术",
    "新视野",
    "新文学史料",
    "新闻大学",
    "新闻记者",
    "新闻界",
    "新闻实践",
    "新闻与传播研究",
    "新闻与写作",
    "新闻战线",
    "新型建筑材料",
    "新型炭材料",
    "新型碳材料",
    "新医学",
    "新中医",
    "信号处理",
    "信息与控制",
    "行政法学研究",
    "修辞学习",
    "畜牧兽医学报",
    "畜牧与兽医",
    "学版",
    "学海",
    "学科教育",
    "学前教育",
    "学前教育研究",
    "学术交流",
    "学术界",
    "学术论坛",
    "学术探索",
    "学术研究",
    "学术月刊",
    "学位与研究生教育",
    "学习与实践",
    "学习与探索",
    "压电与声光",
    "亚太经济",
    "烟台大学学报哲学社会科学版",
    "岩矿测试",
    "岩石矿物学杂志",
    "岩石力学与工程学报",
    "岩石学报",
    "岩土工程学报",
    "岩土力学",
    "研究生教育研究",
    "研究与发展管理",
    "眼科研究",
    "眼外伤职业眼病杂志",
    "扬州大学学报农业与生命科学版",
    "养猪",
    "遥感技术与应用",
    "遥感学报",
    "药物分析杂志",
    "药物生物技术",
    "药学学报",
    "冶金分析",
    "冶金能源",
    "冶金自动化",
    "液晶与显示",
    "液压与气动",
    "医师进修杂志",
    "医学分子生物学杂志",
    "医学与社会",
    "医学与哲学",
    "仪表技术与传感器",
    "仪器仪表学报",
    "遗传",
    "遗传学报",
    "艺术百家",
    "译林",
    "音乐创作",
    "音乐探索四川音乐学院学报",
    "音乐研究",
    "音乐艺术",
    "音乐艺术上海音乐学院学报",
    "银行与企业",
    "印染",
    "印染助剂",
    "印刷技术",
    "应用概率统计",
    "应用化学",
    "应用基础与工程科学学报",
    "应用激光",
    "应用科学学报",
    "应用力学学报",
    "应用气象学报",
    "应用生态学报",
    "应用声学",
    "应用数学",
    "应用数学和力学",
    "应用数学和力学英文版",
    "应用数学学报",
    "应用数学与力学",
    "应用数学与力学英文版",
    "应用心理学",
    "应用与环境生物学报",
    "营养学报",
    "影视技术",
    "影像科学与光化学",
    "影像科学与实践",
    "邮电企业管理",
    "油气储运",
    "油田化学",
    "有机化学",
    "有色金属",
    "有色金属矿山部分",
    "有色金属选矿部分",
    "渔业经济研究",
    "宇航材料工艺",
    "宇航计测技术",
    "宇航学报",
    "语文建设",
    "语文教学通讯",
    "语文研究",
    "语言教学与研究",
    "语言科学",
    "语言文字应用",
    "语言研究",
    "语言与翻译",
    "预测",
    "预算管理与会计",
    "园艺学报",
    "原子核物理评论",
    "原子能科学技术",
    "原子与分子物理学报",
    "远程教育杂志",
    "云南财经大学学报",
    "云南大学学报社会科学版",
    "云南大学学报自然科学版",
    "云南民族大学学报哲学社会科学版",
    "云南社会科学",
    "云南师范大学学报哲学社会科学版",
    "云南天文台台刊",
    "云南植物研究",
    "运筹学学报",
    "杂交水稻",
    "灾害学",
    "早期教育",
    "造船技术",
    "噪声与振动控制",
    "战略与管理",
    "照明工程学报",
    "照相机",
    "哲学动态",
    "哲学研究",
    "浙江大学学报工学版",
    "浙江大学学报理学版",
    "浙江大学学报农业与生命科学版",
    "浙江大学学报人文社会科学版",
    "浙江大学学报医学版",
    "浙江大学学报英文版",
    "浙江大学学报英文版a",
    "浙江大学学报英文版b",
    "浙江大学学报英文版c",
    "浙江档案",
    "浙江金融",
    "浙江经济",
    "浙江林学院学报",
    "浙江林业科技",
    "浙江农业科学",
    "浙江农业学报",
    "浙江社会科学",
    "浙江体育科学",
    "浙江统计",
    "浙江学刊",
    "浙江医学",
    "浙江艺术职业学院学报",
    "浙江预防医学",
    "浙江中医杂志",
    "针刺研究",
    "针织工业",
    "真空",
    "真空科学与技术学报",
    "振动测试与诊断",
    "振动工程学报",
    "振动与冲击",
    "证券市场导报",
    "郑州大学学报医学版",
    "郑州大学学报哲学社会科学版",
    "郑州粮食学院学报",
    "政法论坛",
    "政治经济学评论",
    "政治学研究",
    "政治与法律",
    "知识产权",
    "职业技术教育",
    "职业医学",
    "植物保护",
    "植物保护学报",
    "植物病理学报",
    "植物分类学报",
    "植物检疫",
    "植物生理学通讯",
    "植物生理与分子生物学学报",
    "植物生理与分子生物学学报原植物生理学报",
    "植物生态学报",
    "植物学报",
    "植物学通报",
    "植物研究",
    "植物遗传资源学报",
    "植物营养与肥料学报",
    "植物资源与环境学报",
    "纸和造纸",
    "制冷学报",
    "制造技术与机床",
    "质谱学报",
    "中草药",
    "中成药",
    "中风与神经疾病杂志",
    "中共党史研究",
    "中共中央党校学报",
    "中国癌症研究英文版",
    "中国安全科学学报",
    "中国版权",
    "中国保险",
    "中国比较文学",
    "中国边疆史地研究",
    "中国编辑",
    "中国病毒学",
    "中国病理生理杂志",
    "中国财政",
    "中国藏学",
    "中国草地学报",
    "中国超声医学杂志",
    "中国成人教育",
    "中国出版",
    "中国大学教学",
    "中国当代儿科杂志",
    "中国党政干部论坛",
    "中国档案",
    "中国道教",
    "中国地方病学杂志",
    "中国地方志",
    "中国地震",
    "中国地质",
    "中国地质大学学报社会科学版",
    "中国地质灾害与防治学报",
    "中国典籍与文化",
    "中国电大教育",
    "中国电化教育",
    "中国电机工程学报",
    "中国电力",
    "中国电视",
    "中国调味品",
    "中国动脉硬化杂志",
    "中国俄语教学",
    "中国儿童保健杂志",
    "中国耳鼻咽喉头颈外科杂志",
    "中国法学",
    "中国法医学杂志",
    "中国翻译",
    "中国防痨杂志",
    "中国房地产",
    "中国纺织大学学报",
    "中国腐蚀与防护学报",
    "中国妇幼保健",
    "中国港口建设",
    "中国高等教育",
    "中国高等医学教育",
    "中国高教研究",
    "中国给水排水",
    "中国工业经济",
    "中国工业医学杂志",
    "中国公共卫生提高版",
    "中国公共卫生学报",
    "中国公路学报",
    "中国骨伤",
    "中国管理科学",
    "中国惯性技术学报",
    "中国光学快报英文版",
    "中国广播电视学刊",
    "中国国情国力",
    "中国果树",
    "中国海洋大学学报社会科学版",
    "中国海洋大学学报自然科学版",
    "中国海洋药物",
    "中国航海",
    "中国航天",
    "中国化学快报英文版",
    "中国环境监测",
    "中国环境科学",
    "中国机构",
    "中国机械工程",
    "中国激光",
    "中国急救医学",
    "中国计划生育学杂志",
    "中国记者",
    "中国技术经济科学",
    "中国寄生虫学与寄生虫病杂志",
    "中国家禽",
    "中国监狱学刊",
    "中国教育学刊",
    "中国介入心脏病学杂志",
    "中国介入影像与治疗学",
    "中国金融",
    "中国京剧",
    "中国经济史研究",
    "中国经济问题",
    "中国经贸导刊",
    "中国井矿盐",
    "中国康复医学杂志",
    "中国抗生素杂志",
    "中国科技翻译",
    "中国科技论坛",
    "中国科技期刊研究",
    "中国科学ag辑",
    "中国科学a辑数学",
    "中国科学b辑化学",
    "中国科学c辑生命科学",
    "中国科学d辑地球科学",
    "中国科学e辑技术科学",
    "中国科学f辑信息科学",
    "中国科学g辑物理学力学天文学",
    "中国科学地球科学",
    "中国科学化学",
    "中国科学基金",
    "中国科学技术大学学报",
    "中国科学技术科学",
    "中国科学生命科学",
    "中国科学数学",
    "中国科学物理学力学天文学",
    "中国科学信息科学",
    "中国科学院研究生院学报",
    "中国空间科学技术",
    "中国空间科学杂志",
    "中国口腔种植学杂志",
    "中国矿业",
    "中国矿业大学学报",
    "中国矿业大学学报自然科学版",
    "中国劳动科学",
    "中国老年学杂志",
    "中国历史博物馆馆刊",
    "中国历史地理论丛",
    "中国粮油学报",
    "中国临床解剖学杂志",
    "中国临床心理学杂志",
    "中国临床药理学杂志",
    "中国流通经济",
    "中国麻风杂志",
    "中国媒介生物学及控制杂志",
    "中国煤炭",
    "中国棉花",
    "中国免疫学杂志",
    "中国穆斯林",
    "中国内镜杂志",
    "中国奶牛",
    "中国男科学杂志",
    "中国南方果树",
    "中国能源",
    "中国酿造",
    "中国农村观察",
    "中国农村经济",
    "中国农村水利水电",
    "中国农机化",
    "中国农垦经济",
    "中国农史",
    "中国农业大学学报",
    "中国农业大学学报社会科学版",
    "中国农业会计",
    "中国农业科学",
    "中国农业气象",
    "中国皮肤性病学杂志",
    "中国皮革",
    "中国青年研究",
    "中国青年政治学院学报",
    "中国轻工业经济",
    "中国区域地质",
    "中国全科医学杂志",
    "中国人才",
    "中国人口科学",
    "中国人口资源与环境",
    "中国人力资源开发",
    "中国人民大学报刊复印资料全文复印",
    "中国人民大学复印资料内的原生文献即一次文献",
    "中国人民大学学报",
    "中国人兽共患病学报",
    "中国人兽共患病杂志",
    "中国乳品工业",
    "中国软科学",
    "中国沙漠",
    "中国社会保险",
    "中国社会工作",
    "中国社会经济史研究",
    "中国社会科学",
    "中国社会科学季刊香港现已停刊",
    "中国社会科学评论香港",
    "中国社会科学文摘",
    "中国社会科学院研究生院学报",
    "中国社会科学中英文版",
    "中国摄影",
    "中国神经精神疾病杂志",
    "中国神经科学杂志",
    "中国审计",
    "中国生化药物杂志",
    "中国生态农业学报",
    "中国生物防治",
    "中国生物工程杂志",
    "中国生物化学与分子生物学报",
    "中国生物医学工程学报",
    "中国生物制品学杂志",
    "中国石油大学学报自然科学版",
    "中国实验动物学报",
    "中国实验血液学杂志",
    "中国实用儿科杂志",
    "中国实用妇科与产科杂志",
    "中国实用护理杂志",
    "中国实用内科杂志",
    "中国实用外科杂志",
    "中国实用眼科杂志",
    "中国食草动物",
    "中国食品学报",
    "中国食用菌",
    "中国史研究",
    "中国史研究动态",
    "中国兽药杂志",
    "中国兽医科技",
    "中国兽医科学",
    "中国兽医学报",
    "中国书法",
    "中国蔬菜",
    "中国水产",
    "中国水产科学",
    "中国水稻科学",
    "中国水土保持",
    "中国水运",
    "中国税务",
    "中国饲料",
    "中国塑料",
    "中国糖尿病杂志",
    "中国陶瓷",
    "中国陶瓷工业",
    "中国特色社会主义研究",
    "中国特殊教育",
    "中国体育科技",
    "中国天然药物",
    "中国天主教",
    "中国铁道科学",
    "中国铁路",
    "中国统计",
    "中国投资",
    "中国投资管理",
    "中国图书馆学报",
    "中国图书评论",
    "中国图象图形学报",
    "中国图像图形学报",
    "中国土地科学",
    "中国外语",
    "中国危重病急救医学",
    "中国微生态学杂志",
    "中国卫生经济",
    "中国卫生事业管理",
    "中国卫生统计",
    "中国文化研究",
    "中国文学研究",
    "中国物价",
    "中国物理快报英文版",
    "中国物资流通",
    "中国稀土学报",
    "中国戏剧",
    "中国现代文学研究丛刊",
    "中国现代应用药学",
    "中国心理卫生杂志",
    "中国新药与临床杂志",
    "中国新药杂志",
    "中国刑事法杂志",
    "中国行为医学科学",
    "中国行政管理",
    "中国修复重建外科杂志",
    "中国畜牧杂志",
    "中国学校体育",
    "中国学校卫生",
    "中国循环医学杂志",
    "中国循环杂志",
    "中国养蜂",
    "中国养兔杂志",
    "中国药科大学学报",
    "中国药理学报",
    "中国药理学通报",
    "中国药理学与毒理学杂志",
    "中国药物化学杂志",
    "中国药物依赖性杂志",
    "中国药学杂志",
    "中国医科大学学报",
    "中国医疗器械杂志",
    "中国医学计算机成像杂志",
    "中国医学科学院学报",
    "中国医学伦理学",
    "中国医学影像技术",
    "中国医学影像学杂志",
    "中国医药工业杂志",
    "中国医药学报",
    "中国医院管理",
    "中国医院药学杂志",
    "中国音乐",
    "中国音乐学",
    "中国应用生理学杂志",
    "中国油料作物学报",
    "中国油料作物杂志",
    "中国油脂",
    "中国有色金属学报",
    "中国有线电视",
    "中国语文",
    "中国预防兽医学报",
    "中国园林",
    "中国远程教育上",
    "中国运动医学杂志",
    "中国造船",
    "中国造纸",
    "中国造纸学报",
    "中国沼气",
    "中国哲学史",
    "中国针灸",
    "中国针炙",
    "中国中西医结合杂志",
    "中国中药杂志",
    "中国中医基础医学杂志",
    "中国肿瘤临床",
    "中国铸造装备与技术",
    "中国资产评估",
    "中国宗教",
    "中国综合临床",
    "中国组织化学与细胞化学杂志",
    "中国作家",
    "中华病理学杂志",
    "中华超声影像学杂志",
    "中华传染病杂志",
    "中华创伤杂志",
    "中华儿科杂志",
    "中华耳鼻咽喉头颈外科杂志",
    "中华耳科学杂志",
    "中华放射学杂志",
    "中华放射医学与防护杂志",
    "中华放射肿瘤学杂志",
    "中华风湿病学杂志",
    "中华妇产科杂志",
    "中华肝胆外科杂志",
    "中华肝脏病杂志",
    "中华骨科杂志",
    "中华核医学杂志",
    "中华护理杂志",
    "中华急诊医学杂志",
    "中华急诊医学杂志原急诊医学",
    "中华检验医学杂志",
    "中华结核和呼吸杂志",
    "中华精神科杂志",
    "中华口腔医学杂志",
    "中华劳动卫生职业病杂志",
    "中华老年医学杂志",
    "中华理疗杂志",
    "中华流行病学杂志",
    "中华麻醉学杂志",
    "中华泌尿外科杂志",
    "中华内分泌代谢杂志",
    "中华内科杂志",
    "中华男科学",
    "中华皮肤科杂志",
    "中华普通外科杂志",
    "中华器官移植杂志",
    "中华全科医学杂志",
    "中华烧伤杂志",
    "中华神经科杂志",
    "中华神经外科杂志",
    "中华肾脏病杂志",
    "中华实验和临床病毒学杂志",
    "中华实验外科杂志",
    "中华手外科杂志",
    "中华外科杂志",
    "中华微生物学和免疫学杂志",
    "中华围产医学杂志",
    "中华文史论丛",
    "中华物理医学与康复杂志",
    "中华显微外科杂志",
    "中华消化杂志",
    "中华小儿外科杂志",
    "中华心血管病杂志",
    "中华胸心血管外科杂志",
    "中华血液学杂志",
    "中华眼底病杂志",
    "中华眼科杂志",
    "中华医学遗传学杂志",
    "中华医学杂志",
    "中华医院感染学杂志",
    "中华医院管理杂志",
    "中华预防医学杂志",
    "中华整形外科杂志",
    "中华职业医学",
    "中华纸业",
    "中华肿瘤杂志",
    "中南财经大学学报",
    "中南财经政法大学学报",
    "中南大学学报医学版",
    "中南大学学报医学报",
    "中南大学学报自然科学版",
    "中南工业大学学报",
    "中南公路工程",
    "中南民族大学学报人文社会科学版",
    "中南民族学院学报哲学社会科学版",
    "中篇小说选刊",
    "中山大学学报社会科学版",
    "中山大学学报医学科学版",
    "中山大学学报自然科学版",
    "中山医科大学学报",
    "中兽医医药杂志",
    "中外法学",
    "中外管理",
    "中外军事影视",
    "中外科技信息",
    "中文信息学报",
    "中小型电机",
    "中小学管理",
    "中小学英语教学与研究",
    "中学地理教学参考",
    "中学语文教学",
    "中央财经大学学报",
    "中央民族大学学报哲学社会科学版",
    "中央音乐学院学报",
    "中药材",
    "中药新药与临床药理",
    "中药药理与临床",
    "中医杂志",
    "中原文物",
    "中州学刊",
    "钟山",
    "肿瘤",
    "种子",
    "重庆大学学报社会科学版",
    "重庆大学学报自然科学版",
    "重庆环境科学",
    "周易研究",
    "轴承",
    "蛛形学报",
    "竹子研究汇刊",
    "著作权",
    "铸造",
    "铸造技术",
    "装饰",
    "资源科学",
    "紫金山天文台台刊",
    "自动化学报",
    "自动化仪表",
    "自然辩证法通讯",
    "自然辩证法研究",
    "自然科学进展",
    "自然科学史研究",
    "自然杂志",
    "自然灾害学报",
    "自然资源学报",
    "宗教学研究",
    "综合运输",
    "组合机床与自动化加工技术",
    "钻井液与完井液",
    "作家",
    "作物品种资源",
    "作物学报",
    "作物杂志"
   )
def isCore(journal: String) : Int ={
  for(coreJournal <- coreJournals){
    if(coreJournal.indexOf(journal) >=0 ||
      journal.indexOf(coreJournal) >=0
    ) return 1
  }
  0
}

  def main(args: Array[String]) {
    println(isCore("actageologicasinic"))
  }
}
