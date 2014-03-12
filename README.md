MembershipApplication
===================


一、俱乐部会员预约 Tee time reservation

1. standing reservation会员可以进行预定，需提供（开始时间，结束时间，日期，场地编号，会员ID），然后由manager审批，录入standing reservation table
2. reservation：
任何会员可以于提前不超过一周前预约tee time,须提供日期，周几，时间，预约人姓名，预约人优先级，组员人数，cart数量，联系电话。工作人员录入天气，事件（优先级高的会员允许一周不超过两次覆盖优先级低的会员的预约，此时工作人员联系优先级低的会员修改预约），最后录入reservation table。
 
二、申请俱乐部会员 Membership application（已部分实现）

1. 提供基本信息（申请日期，申请人姓名，推荐人姓名，申请会员类型，信用卡信息），输入数据库，application table。
2. 需要已经入会两年以上的会员推荐（比对推荐人的会员信息----->入会日期，时间------>是否大于两年，member table）。
3. 需要审核栏（四个审核状态，accept, deny, request additional info, defer，没有自动算分模式，审核委员会人工输入即可，审核通过，即可成为会员）。
 


