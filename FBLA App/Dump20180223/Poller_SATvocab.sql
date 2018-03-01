CREATE DATABASE  IF NOT EXISTS `Poller` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `Poller`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 52.41.161.91    Database: Poller
-- ------------------------------------------------------
-- Server version	5.5.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `SATvocab`
--

DROP TABLE IF EXISTS `SATvocab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SATvocab` (
  `idVocab` int(11) NOT NULL,
  `vocabWords` varchar(45) NOT NULL,
  `typeOfWord` varchar(5) NOT NULL,
  `vocabMeanings` longtext NOT NULL,
  PRIMARY KEY (`idVocab`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SATvocab`
--

LOCK TABLES `SATvocab` WRITE;
/*!40000 ALTER TABLE `SATvocab` DISABLE KEYS */;
INSERT INTO `SATvocab` VALUES (1,'Abstract','adj.','complex,conceptional,regard'),(2,'Abstruse','adj.','recondite,deep,recondite'),(3,'Acclaim','noun','applause,applause,compliment'),(4,'Accolade','noun','approval,approval,acclaim'),(5,'Acquiescent','adj.','yielding,acknowledging,approving'),(6,'Acrimony','noun','harshness,animosity,unkindness'),(7,'Adamant','adj.','stubborn,unyeilding,stubborn'),(8,'Admonish','verb','warn,chide,scold'),(9,'Adroit','adj.','skillful,apt,cunning'),(10,'Adversary','noun','antagonist,opponent,antagonist'),(11,'Advocate','noun','promoter,favor,campaigner'),(12,'Aesthetic','adj.','beautiful, beautiful,artful'),(13,'Affable','adj.','amiable,friendly,amiable'),(14,'Affirmation','noun','declaration,confirmation,testimony'),(15,'Alienate','verb','hostility,disunite,make indifferent'),(16,'Aloof','adj.','unsociable,distant,reserved'),(17,'Altruistic','adj.','unselfish,benevolent,unselfish'),(18,'Ambidextrous','adj.','deceitful,two-faced,skillful'),(19,'Ambiguous','adj.','vague,enigmatic,vague'),(20,'Ambivalence','noun','uncertainty,hesitation,equivocation'),(21,'Ameliorate','verb','alleviate,improve,alleviate'),(22,'Amity','noun','friendship,friendship,benevolence'),(23,'Amorphous','adj.','formless,formless,baggy'),(24,'Analogous','adj.','similar,alike,uniform'),(25,'Anarchy','noun','chaos,chaos,rebellion'),(26,'Anathema','noun','bane,curse,abomination'),(27,'Animosity','noun','hatred,acrimony,hate'),(28,'Antagonistic','adj.','hostile,combative,opposing'),(29,'Antiquated','adj.','aged,obsolete,archaic'),(30,'Antithesis','noun','converse,counter ,condradictory'),(31,'Apathy','noun','coldness,indifference,stoicism'),(32,'Apex','noun','top,climax,maximum'),(33,'Appease','verb','satisfy,alleviate,soothe'),(34,'Apprehension','noun','fear,worry,capture'),(35,'Arbitrary','adj.','superficial,random,tyrannical'),(36,'Arcane','adj.','secret,hidden,mysterious'),(37,'Archaic','adj.','ancient,antiquated,ancient'),(38,'Arrogant','adj.','cocky,conceited ,pretentious'),(39,'Articulate','verb','clear,clear,speak'),(40,'Ascendance','noun','dominance,rise,scaling'),(41,'Ascetic','adj.','strict,abstaining,self-denying'),(42,'Asperity','noun','harshness,acrimony,harshness'),(43,'Assail','verb','abuse,criticize,assault'),(44,'Assiduous','adj.','hard working,diligent,laborious'),(45,'Assuage','verb','soothe,alleviate,ameliorate'),(46,'Astute','adj.','bright,adroit,brainy'),(47,'Atrophy','noun','downfall,degeneration,detoriation'),(48,'Audacious','adj.','daring,courageous,risky'),(49,'Augment','verb','boost,develop,amplify'),(50,'Auspicious','adj.','encouraging,fortunate,hopeful'),(51,'Austere','adj.','cold,stern,sober'),(52,'Authoritarian','adj.','autocratic,totalitarian,domingo'),(53,'Autonomous','adj.','independent,innocent,na?ve'),(54,'Avarice','noun','greediness,intrinsic,fundamental'),(55,'Averse','adj.','hostile,native,natural'),(56,'Baleful','adj.','sinister,innocent,bland'),(57,'Banal','adj.','boring,novelty,modernization'),(58,'Beguile','verb','cheat,enigmatic,ambiguous'),(59,'Belie','verb','disprove,colorless,innocuous'),(60,'Belligerent','adj.','fierce,impudent,cheeky'),(61,'Benediction','noun','blessing,broke,bankrupt'),(62,'Benevolent','adj.','kind,initiate,prompt'),(63,'Benign','adj.','amiable,insurmountable,challenging'),(64,'Bequeath','verb','entrust,elusive,ethereal'),(65,'Blasphemy','noun','cursing,veracity,honesty'),(66,'Blight','noun','disease,interregator,interviewer'),(67,'Blithe','noun','happy,incessant,everlasting'),(68,'Bolster','verb','strengthen,sporadic,alternating'),(69,'Bombast','verb','boasting,stubborn ,willful'),(70,'Brevity','verb','shortness,inherent,fundamental'),(71,'Bumptious','noun','conceited,reverse,capsize'),(72,'Cacophony','noun','noise,irritable,pestulant'),(73,'Cajole','verb','flatter,paradox,sarcasm'),(74,'Capacious','adj.','abundant,indecisive,vacillating'),(75,'Capitulate','verb','succumb,impertinent,insolent'),(76,'Capricious','adj.','erratic,lingo,terminology'),(77,'Castigate','verb','censure,prejudice,bias'),(78,'Caustic','adj.','corrosive,sprightly,cheerful'),(79,'Celerity','noun','alacrity,risk,peril'),(80,'Censure','noun','criticizing,abandon,discard'),(81,'Chasten','verb','humiliate,witty,jovial'),(82,'Chastise','verb','scold,ecstatic,euphoric'),(83,'Choler','noun','anger,shrewd,astute'),(84,'Circumscribe','verb','enclose,moment,occasion'),(85,'Circumspect','verb','cautious,contrast,put adjacent to'),(86,'Clemency','noun','charity,rouse,stimulate'),(87,'Cloister','noun','sanctuary,sprightly,jaundice'),(88,'Coalesce','verb','combine,concise,brief'),(89,'Coerce','verb','constrain,mourn,grieve'),(90,'Complacent','adj.','egotistic,suffer,decay'),(91,'Compliant','adj.','obedient,supressed,dormant'),(92,'Composure','noun','calmness,praise,acclaim'),(93,'Comprehensive','adj.','inclusive,birthright,heritage'),(94,'Concede','verb','accept,lazy,indolent'),(95,'Conciliatory','adj.','placid,humor,flippancy'),(96,'Concise','adj.','laconic,glorify,praise'),(97,'Concur','verb','agree,indolent,lethargic'),(98,'Condone','verb','overlook,opposed,reluctant'),(99,'Confound','verb','astonish,hate,abominate'),(100,'Consonance','noun','agreement,condescending,arrogant'),(101,'Consummate','verb','best,wordy,rambling'),(102,'Contend','verb','fight,coherent,reasoned'),(103,'Contingent','adj.','possible,preposterous,absurd'),(104,'Contract','verb','agreement,melancholy,somber'),(105,'Contrite','adj.','regretful,capricious,fanciful'),(106,'Conundrum','noun','enigma,shrivel ,wilt'),(107,'Converge','verb','gather,wrinkled,aged'),(108,'Conviction','noun','opinion,chauvinism,racism'),(109,'Convivial','adj.','mirthful,surrender,succumb'),(110,'Copious','adj.','abundant,repression,oppression'),(111,'Cordial','adj.','sociable,advocate,fanatic'),(112,'Corporeal','adj.','fleshy,apex ,pinnacle'),(113,'Corroborate','verb','approve,independent,sovereign'),(114,'Criteria','noun','benchmark,greed,materialism'),(115,'Cryptic','adj.','secret,reluctant,loath'),(116,'Culpable','adj.','blameful,malevolent,vidictive'),(117,'Cupidity','adj.','greediness,hackneyed,cliched'),(118,'Cursory','adj.','hasty,mesmorize,charm'),(119,'Daunted','adj.','alarm,contradict,disprove'),(120,'Debilitate','verb','blunt,aggressive,confrontational'),(121,'Decadence','noun','corruption,blessing,sanction'),(122,'Defame','verb','disgrace,Benign,generous'),(123,'Deference','noun','obedience,benevolent,generous'),(124,'Delineate','verb','describe,bestow,donate'),(125,'Denounce','verb','attack,profanity,sacrilege'),(126,'Depleted','adj.','consume,stain,affliction'),(127,'Deplore','verb','regret,carefree,unthinking'),(128,'Depravity','noun','corruption,stengthen,sustain'),(129,'Deprecate','verb','condemn,pretentiousness,swagger'),(130,'Deride','verb','insult,conciseness,briefness'),(131,'Despondent','adj.','depressed,arrogant,boastful'),(132,'Despot','noun','dictator,dissonance,disharmony'),(133,'Destitute','adj.','depleted,flatter,coax'),(134,'Desultory','adj.','aimless,roomy,spacious'),(135,'Detached','adj.','disconnect,relent,surrender'),(136,'Deterrent','noun','restraint,whimsical,fickle'),(137,'Devious','adj.','deceitful,reprimand,criticize'),(138,'Dexterity','noun','ability,sarcastic,sharp'),(139,'Diatribe','verb','criticism,briskness,swiftness'),(140,'Didactic','adj.','educational,reprimand,condemn'),(141,'Digress','verb','deviate,reprimand,censure'),(142,'Dilatory','adj.','procrastinating,censure,chasten'),(143,'Diligence','noun','activity,restrict,confine'),(144,'Diminution','noun','lessening,wary,prudent'),(145,'Discerning','adj.','anticipate,compassion,kindness'),(146,'Disclose','verb','reveal,unite,combine'),(147,'Discord','noun','disharmony,intimidate,compel'),(148,'Discourse','noun','chat,smug,satisfied'),(149,'Discriminating','adj.','hate,acquiescent,submissive'),(150,'Disdain','noun','hate,poise,tranquility'),(151,'Disinclination','noun','hatred,ample,inclusive'),(152,'Disparage','verb','criticize,forfeit,admit'),(153,'Disparate','verb','different,appeasing,pacifying'),(154,'Dispassionate','adj.','detached,brief,to the point'),(155,'Disperse','verb','scatter,coincide,harmonize'),(156,'Disputatious','adj.','contentious,overlook,ignore'),(157,'Disseminate','verb','spread,puzzle,bewilder'),(158,'Dissent','noun','disagree,accomplish,accomplished'),(159,'Dissolution','noun','disbanding,assert,compete'),(160,'Dissonance','noun','disagreement,group,dependent'),(161,'Distended','adj.','swollen,agreement,catch'),(162,'Divergence','noun','deviation,generous,worthy'),(163,'Diverse','adj.','varied,tycoon,entrepeneur'),(164,'Document','verb','record,scoundrel,criminal'),(165,'Dogmatic','adj.','unbending,mischievousness,spite'),(166,'Doleful','adj.','mournful,slander,hurtful'),(167,'Dubious','adj.','doubtful,acquiescent,flexible'),(168,'Duplicity','noun','deception,spoiled,flAWED'),(169,'Eccentric','adj.','strange,INADEQUATE,SCANTY'),(170,'Eclectic','adj.','diverse,WANDER,STROLL'),(171,'Efface','verb','obliterate,HONEYED,SMOOTH'),(172,'Effervescence','noun','vivacity,deception ,DeCEIT'),(173,'Efficacy','noun','effectiveness,SYSTEMATIC,Meticulous'),(174,'Elaborate','verb','complex,Methodical,Systematic'),(175,'Elated','adj.','thrilled,infinitesimal,small'),(176,'Eloquence','noun','articulacy,miscomprehend,misunderstand'),(177,'Elusive','adj.','baffling,alleviate,diminish'),(178,'Emaciated','adj.','thin,little,degree'),(179,'Embellish','verb','beautify,appease,placate'),(180,'Embryonic','adj.','developing,pessimistic,gloomy'),(181,'Emulate','verb','imitate,boring ,routine'),(182,'Endemic','adj.','native,countless,numerous'),(183,'Endorse','verb','support,blossoming,hopeful'),(184,'Enervate','verb','weaken,vague,tenous'),(185,'Engender','verb','produce,wicked,immoral'),(186,'Enhance','verb','improve,lax,inattentive'),(187,'Enigma','noun','puzzle,novice,beginner'),(188,'Enmity','noun','hostility,night-time,of the night'),(189,'Ephemeral','adj.','fleeting,wistful,longing'),(190,'Epic','adj.','grand,infamy,dishonor'),(191,'Equanimity','noun','composure,originality,innovation'),(192,'Equivocal','adj.','ambiguous,hint ,shade'),(193,'Eradicate','verb','eliminate,abolish,invalidate'),(194,'Erratic','adj.','unpredicatable,raise,cherish'),(195,'Erroneous','adj.','wrong,adamant,stubborn'),(196,'Erudition','noun','learning,unbiased,goal'),(197,'Esoteric','adj.','obscure,eradicate,annihilate'),(198,'Ethereal','adj.','unearthly,stupor,void'),(199,'Eulogize','verb','praise,unaware,ignorant'),(200,'Euphemism','noun','substitution,vague,incomprehensive'),(201,'Evasive','adj.','elusive,flattering,submissive'),(202,'Exacerbate','verb','aggravate,outdated,archaic'),(203,'Exalt','verb','praise,stubborn ,adamant'),(204,'Execute','verb','implement,conspicuous,blatant'),(205,'Exemplary','adj.','excellent,slow,insensitive'),(206,'Exemplify','verb','epitomize,prevent,hinder'),(207,'Exhaustive','adj.','extensive,menacing,warning'),(208,'Exonerate','verb','pardon,difficult,tedious'),(209,'Expedient','adj.','convenient,repentant,ashamed'),(210,'Explicit','adj.','precise,puzzle,challenge'),(211,'Expunge','verb','obliterate,meet,congregate'),(212,'Expurgate','verb','purge,sincerity,confidence'),(213,'Extemporaneous','adj.','impromptu,friendly,cordial'),(214,'Extol','verb','praise,abundant,plentiful'),(215,'Extraneous','adj.','irrelevant,polite,convivial'),(216,'Extricate','verb','remove,bodily,physical'),(217,'Exuberant','adj.','excited,confirm,substantiate'),(218,'Facilitate','verb','aid,enigmatic,obsure'),(219,'Fallacious','adj.','misleading,liable,responsible'),(220,'Fanaticism','noun','zeal,greed,avarice'),(221,'Fastidious','adj.','finicky,superficial,brief'),(222,'Fervor','noun','zeal,frightened,intimidated'),(223,'Fickle','adj.','inconsistent,incapacitate,hinder'),(224,'Flaccid','adj.','limp,depravity,corruption'),(225,'Flagrant','adj.','blatant,insult,deprecate'),(226,'Fledgling','noun','hatchling,admiration,respect'),(227,'Flippancy','noun','disrespect,define,outline'),(228,'Fluctuate','verb','vary,deprecate,criticize'),(229,'Foment','verb','provoke,exhausted,used up'),(230,'Foresight','noun','forethought,Deprecate,condemn'),(231,'Frivolity','noun','merriment,decadence,immorality'),(232,'Frugal','adj.','thrifty,deplore,denounce'),(233,'Fulminate','verb','explode,ridicule,scoff'),(234,'Furtive','adj.','stealthy,hopeless,pessimistic'),(235,'Futile','adj.','useless,domingo,authoritarian'),(236,'Garbled','verb','jumbled,poor,insolvent'),(237,'Garish','adj.','gaudy,halfhearted,random'),(238,'Garner','verb','gather,alienated,separated'),(239,'Garrulous','adj.','talkative,prevention,restriction'),(240,'Genial','adj.','pleasant,tricky,conniving'),(241,'Germane','adj.','relevant,nimbleness,handiness'),(242,'Gesticulate','verb','gesture,tirade,criticism'),(243,'Girth','noun','circumference,educational,moralistic'),(244,'Glib','adj.','slick,deviate,wander'),(245,'Glutton','noun','food lover,negligent,slow'),(246,'Grandiose','adj.','extravagent,meticulousness,carefulness'),(247,'Gratuitous','adj.','unwarranted,reduction,decrease'),(248,'Gravity','noun','severity,perceptive,astute'),(249,'Gregarious','adj.','sociable,reveal,divulge'),(250,'Gullible','adj.','naive,dispute,disagreement'),(251,'Hackneyed','adj.','cliched,conversation,discussion'),(252,'Hamper','verb','impede,discerning,astute'),(253,'Haphazard','adj.','random,scorn,disregard'),(254,'Harangue','noun','tirade,reluctance,aversion'),(255,'Harbor','verb','shelter,belittle,mock'),(256,'Hardy','adj.','resilient,incongruent,dissimilar'),(257,'Haughty','adj.','arrogant,unemotional,detatched'),(258,'Hedge','noun','evade,scatter,diffuse'),(259,'Hedonism','noun','pleasure seeking,obscure,dense'),(260,'Heed','verb','pay attention,entrepeneur,investor'),(261,'Heinous','adj.','shocking,romantic,idealist'),(262,'Heresy','noun','dissent,luxury ,affluence'),(263,'Hiatus','noun','break,pretentious,flamboyant'),(264,'Hierarchy','noun','ranking,peacekeeper,peace-lover'),(265,'Homage','noun','honor,measly,miserable'),(266,'Homogenous','adj.','uniform,epitome,archetype'),(267,'Hyperbole','noun','exaggeration,equivalence,correspondence'),(268,'Hypocrite','noun','fraud,narrow,provincial'),(269,'Hypothetical','adj.','theoretical,stinginess,prudence'),(270,'Idolatry','noun','worship,supporter,enthusiast'),(271,'Imbue','verb','permeate,scarcity,rarity'),(272,'Imminent','adj.','impending,financial,economical'),(273,'Immutable','adj.','unchangeable,arcane,dull'),(274,'Impair','verb','damage,fondness,affinity'),(275,'Impasse','noun','deadlock,poverty,destitution'),(276,'Impassive','adj.','emotionless,automatic,mechanical'),(277,'Impede','verb','hinder,destructive,malicious'),(278,'Impetuous','adj.','impulsive,discernment,perceptiveness'),(279,'Implement','verb','apply,examine,scrutinize'),(280,'Implication','noun','suggestion,permeate,infuse'),(281,'Implicit','adj.','implied,crabbiness,peevishness'),(282,'Impostor','noun','phony,benevolence,charity'),(283,'Impudence','noun','rudeness,apathetic,indifferent'),(284,'Impugn','verb','accuse,religious,virtuous'),(285,'Impunity','noun','exemption,concise,brief'),(286,'Inadvertent','adj.','unintended,pacify,appease'),(287,'Inane','adj.','silly,commonplace,clich?'),(288,'Inaugurate','verb','begin,conceivable,credible'),(289,'Incessant','adj.','persistent,excess,abundance'),(290,'Inchoate','adj.','undeveloped,arrogant,pretentious'),(291,'Incidental','adj.','secondary,cumbersome,hefty'),(292,'Incisive','adj.','sharp,warning,omen'),(293,'Incite','verb','arouse,powerful,persuasive'),(294,'Inclusive','adj.','everything,realistic,sensible'),(295,'Incompatible','adj.','unsuited,unstable,uncertain'),(296,'Incongruous','adj.','incompatible,prevent,exclude'),(297,'Incontrovertible','adj.','undeniable,intelligent,talented'),(298,'Incorrigible','adj.','incurable,ancestor,forerunner'),(299,'Incredulous','adj.','disbelieving,preference,liking'),(300,'Indefatigable','adj.','untiring,arrogant,conceited'),(301,'Indict','verb','accusing,ostentatious,pompous'),(302,'Indifferent','adj.','uninterested,widespread,ubiquitous'),(303,'Indigent','adj.','poor,fabrication,deception'),(304,'Indiscriminate','adj.','unselective,primitive,ancient'),(305,'Indolent','adj.','lazy,wasteful,extravagent'),(306,'Induce','verb','encourage,phenomenal,extraordinary'),(307,'Indulgent','adj.','lenient,deep,reflective'),(308,'Inert','adj.','lifeless,plentiful,abundant'),(309,'Infallible','adj.','dependable'),(310,'Infer','verb','predict'),(311,'Infiltrate','verb','penetrate'),(312,'Ingenuous','adj.','honest'),(313,'Inherent','adj.','hereditary'),(314,'Innate','adj.','native'),(315,'Innocuous','adj.','harmless'),(316,'Innovation','noun','change'),(317,'Inscrutable','adj.','hidden'),(318,'Insipid','adj.','banal'),(319,'Insolent','adj.','bold'),(320,'Insolvent','adj.','broke'),(321,'Instigate','verb','influence'),(322,'Insuperable','adj.','impassible'),(323,'Intangible','adj.','indefinite'),(324,'Integrity','noun','honor'),(325,'Interlocutor','noun','speaker'),(326,'Interminable','adj.','infinite'),(327,'Intermittent','adj.','irregular'),(328,'Intractable','adj.','difficult'),(329,'Intrinsic','adj.','basic'),(330,'Invert','verb','reverse'),(331,'Irascible','adj.','crabby'),(332,'Irony','noun','sarcasm'),(333,'Irresolute','adj.','indecisive'),(334,'Irreverent','adj.','disrespectable'),(335,'Jargon','noun','dialect'),(336,'Jaundice','verb','bias'),(337,'Jaunty','adj.','lively'),(338,'Jeopardy','noun','danger'),(339,'Jettison','verb','eject'),(340,'Jocular','adj.','funny'),(341,'Jubilant','adj.','happy'),(342,'Judicious','adj.','wise'),(343,'Juncture','noun','circumstance'),(344,'Juxtapose','verb','pair'),(345,'Kindle','verb','blaze'),(346,'Kinetic','adj.','energetic'),(347,'Laconic','adj.','brief'),(348,'Lament','verb','moan'),(349,'Languish','verb','droop'),(350,'Latent','adj.','hidden'),(351,'Laud','verb','acclaim'),(352,'Legacy','noun','heritage'),(353,'Lethargic','adj.','sluggish'),(354,'Levity','noun','silliness'),(355,'Lionize','verb','praise'),(356,'Listless','adj.','spiritless'),(357,'Loath','verb','against'),(358,'Loathe','verb','abhor'),(359,'Lofty','adj.','aerial'),(360,'Loquacious','adj.','talkative'),(361,'Lucid','adj.','clear'),(362,'Ludicrous','adj.','absurd'),(363,'Lugubrious','adj.','gloomy'),(364,'Magnanimous','adj.','Santa Claus'),(365,'Magnate','verb','aristocrat'),(366,'Malediction','noun','curse'),(367,'Malefactor','noun','criminal'),(368,'Malice','verb','hate'),(369,'Malign','verb','hurtful'),(370,'Malleable','adj.','pliable'),(371,'Marred','adj.','damage'),(372,'Meager','adj.','small'),(373,'Meander','verb','wander'),(374,'Mellifluous','adj.','mellow'),(375,'Mendacity','noun','fraud'),(376,'Methodical','adj.','precise'),(377,'Meticulous','adj.','detailed'),(378,'Minute','adj.','small'),(379,'Misconstrue','verb','mistake'),(380,'Mitigate','verb','weaken'),(381,'Modicum','noun','scrap'),(382,'Mollify','verb','soothe'),(383,'Monologue','noun','lecture'),(384,'Morose','adj.','pessimistic'),(385,'Mundane','adj.','banal'),(386,'Myriad','adj.','infinite'),(387,'Nascent','adj.','developing'),(388,'Nebulous','adj.','unclear'),(389,'Nefarious','adj.','evil'),(390,'Negligent','adj.','careless'),(391,'Neophyte','noun','Noob'),(392,'Nocturnal','adj.','night'),(393,'Nostalgic','adj.','homesick'),(394,'Notoriety','noun','reputation'),(395,'Novelty','noun','newness'),(396,'Nuance','noun','shading'),(397,'Nullify','verb','cancel'),(398,'Nurture','verb','feed'),(399,'Obdurate','adj.','stubborn'),(400,'Objective','adj.','detached'),(401,'Objurgate','verb','chastise'),(402,'Obliterate','verb','annihilate'),(403,'Oblivion','noun','disregard'),(404,'Oblivious','adj.','abesent'),(405,'Obscure','adj.','ambiguous'),(406,'Obsequious','adj.','compliant'),(407,'Obsolete','adj.','antique'),(408,'Obstinate','adj.','contradictory'),(409,'Obtrusive','adj.','busy'),(410,'Obtuse','adj.','insensitive'),(411,'Obviate','verb','anticipate'),(412,'Ominous','adj.','baleful'),(413,'Omniscient','adj.','wise'),(414,'Onerous','adj.','demanding'),(415,'Opalescent','adj.','bright'),(416,'Opaque','adj.','cloudy'),(417,'Opportunist','noun','pioneer'),(418,'Optimist','noun','dreamer'),(419,'Opulence','noun','fortune'),(420,'Ostentatious','adj.','showy'),(421,'Qualify','verb','authorize'),(422,'Quandary','noun','bind'),(423,'Quarantine','verb','separation'),(424,'Quell','verb','crush'),(425,'Querulous','adj.','complaining'),(426,'Quiescent','adj.','dormant'),(427,'Quintessential','adj.','ultimate'),(428,'Quixotic','adj.','impulsive'),(429,'Rampant','adj.','aggressive'),(430,'Ratify','verb','approve'),(431,'Rebuff','verb','decline'),(432,'Rebuke','verb','oppose'),(433,'Rebuttal','noun','answer'),(434,'Recant','verb','contradictory'),(435,'Sagacity','noun','comprehension'),(436,'Salubrious','adj.','healthy'),(437,'Salutary','adj.','beneficial'),(438,'Sanction','verb','accredit'),(439,'Sanguine','adj.','animated'),(440,'Sardonic','adj.','arrogant'),(441,'Satire','noun','burlesque'),(442,'Saturate','verb','immerse'),(443,'Savory','adj.','agreeably'),(444,'Scanty','adj.','bare'),(445,'Scrupulous','adj.','critical'),(446,'Scrutinize','verb','analyze'),(447,'Seclusion','noun','desolation'),(448,'Sectarian','adj.','dogmatic'),(449,'Seditious','adj.','defiant'),(450,'Sedulous','adj.','active'),(451,'Sententious','adj.','pretentious'),(452,'Serpentine','adj.','clever'),(453,'Servile','adj.','despicable'),(454,'Skeptic','noun','cynic'),(455,'Slander','verb','defile'),(456,'Slough','noun','bog'),(457,'Solemn','adj.','glum'),(458,'Somber','adj.','bleak'),(459,'Sonorous','adj.','powerful'),(460,'Specious','adj.','deceptive'),(461,'Spendthrift','noun','imprudent'),(462,'Sporadic','adj.','irregular'),(463,'Spurious','adj.','artificial'),(464,'Stagnant','adj.','dead'),(465,'Stalwart','adj.','athletic'),(466,'Stanch','verb','stem'),(467,'Static','adj.','fixed'),(468,'Staunch','adj.','faithful'),(469,'Steadfast','adj.','bound'),(470,'Stealth','noun','slyness'),(471,'Stoic','adj.','dispassionate'),(472,'Strident','adj.','loud'),(473,'Stupefy','verb','daze'),(474,'Stymie','verb','block'),(475,'Subjugate','verb','compel'),(476,'Sublime','adj.','abstract'),(477,'Submissive','adj.','humble'),(478,'Subtle','adj.','faint'),(479,'Succinct','adj.','blunt'),(480,'Succor','noun','aid'),(481,'Sumptuous','adj.','deluxe'),(482,'Superfluous','adj.','excessive'),(483,'Surpass','verb','beat'),(484,'Surreptitious','adj.','hidden'),(485,'Sustain','verb','carry'),(486,'Sycophant','noun','minion'),(487,'Symmetry','noun','balance'),(488,'Taciturn','adj.','mute'),(489,'Tangent','adj.','contiguous'),(490,'Tantamount','adj.','identical'),(491,'Tedious','adj.','annoying'),(492,'Temper','noun','attitude'),(493,'Tenacious','adj.','determined'),(494,'Tentative','adj.','indefinite'),(495,'Tenuous','adj.','delicate'),(496,'Terse','adj.','abrupt'),(497,'Thrifty','adj.','cheap'),(498,'Timorous','adj.','hesitant'),(499,'Tirade','noun','dispute'),(500,'Torpid','adj.','apethetic'),(501,'Translucent','adj.','crystal'),(502,'Trepidation','noun','apprehension'),(503,'Trite','adj.','corny'),(504,'Truculent','adj.','aggressive'),(505,'Turbulence','noun','commotion'),(506,'Tyranny','noun','domination'),(507,'Ubiquitous','adj.','universal'),(508,'Unanimous','adj.','agreed'),(509,'Undermine','verb','cripple'),(510,'Undulate','verb','oscillate'),(511,'Unerring','adj.','certain'),(512,'Uniform','adj.','compatible'),(513,'Unkempt','adj.','crude'),(514,'Unprecedented','adj.','abnormal'),(515,'Upbraid','verb','blame'),(516,'Usurp','verb','arrogate'),(517,'Usury','noun','exploitation'),(518,'Vacillate','verb','alternate'),(519,'Vacuous','adj.','dull'),(520,'Vagary','noun','fancy'),(521,'Vagrant','noun','wanderer'),(522,'Valedictory','adj.','parting'),(523,'Validate','verb','certify'),(524,'Vapid','adj.','boring'),(525,'Vehement','adj.','forceful'),(526,'Venerate','verb','admire'),(527,'Veracity','noun','authenticity'),(528,'Verbose','adj.','talkative'),(529,'Versatile','adj.','adoptable'),(530,'Vestige','noun','evidence'),(531,'Viable','adj.','feasible'),(532,'Vilify','verb','abuse'),(533,'Virtuoso','noun','genius'),(534,'Virulent','adj.','destructive'),(535,'Viscous','adj.','tenacious'),(536,'Vociferous','adj.','clamorous'),(537,'Volatile','adj.','capricious'),(538,'Voluble','adj.','verbal'),(539,'Vulnerable','adj.','exposed'),(540,'Waive','verb','abandon'),(541,'Wane','verb','decline'),(542,'Wanton','adj.','promiscuous'),(543,'Warranted','verb','approve'),(544,'Wastrel','noun','vagabond'),(545,'Wax','verb','increase'),(546,'Whimsical','adj.','amusing'),(547,'Wither','verb','deteriorate'),(548,'Wizened','adj.','reduced'),(549,'Xenophobia','noun','animosity'),(550,'Yield','verb','allow'),(551,'Yoke','noun','tie'),(552,'Zealot','noun','enthusiast'),(553,'Zenith','noun','apex');
/*!40000 ALTER TABLE `SATvocab` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-23 20:51:06
