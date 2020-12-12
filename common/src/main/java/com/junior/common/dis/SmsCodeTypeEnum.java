package com.junior.common.dis;

/**
 * @author wangyiwen
 * @version 1.0 Created in 2019-10-21 10:30
 */
public enum SmsCodeTypeEnum {
    REGISTER(0, "注册"),
    LOGIN(1, "登录"),
    LOGIN_SOCIAL(2, "第三方登录"),
    CHANGE_PASSWORD(3, "修改密码"),
    FORGET_PASSWORD(4, "忘记密码"),
    CHANGE_PHONE(5, "换绑手机"),
    REGISTER_SUCCESS(6, "注册成功通知"),
    INVITE_SUCCESS(7, "邀请成功通知"),
    BAN_NORMAL_USER(8, "冻结普通会员"),
    BAN_MEMBER(9, "冻结社员"),
    BAN_MANAGER(10, "冻结注册店长"),
    RECHARGE(11, "充值短信通知"),
    CONSUME(12, "社员消费短信通知"),
    LEVEL_UP(13, "身份升级短信通知"),
    CONSUME_POINT(14, "会员消费奖励积分短信通知"),
    NORMAL_CONSUME(15, "会员消费短信通知"),
    MEMBER_CONSUME_POINT(16, "社员消费奖励积分短信通知"),
    INTEREST_POINT(17, "利息收益积分短信通知"),
    MERCHANT_DELIVER(18, "提醒商家发货短信通知"),
    RESERVE_MANAGER_MERCHANT(19, "注册店长推荐商家入驻短信通知"),
    OFFICIAL_MANAGER_MERCHANT(20, "正式店长推荐商家入驻短信通知"),
    RESERVE_TO_OFFICIAL(21, "注册店长转为正式店长通知短信"),
    MANAGER_STUDIO(22, "店长工作室通知短信"),
    MANAGER_MERCHANT(23, "店长推荐商户的销售额返现通知短信"),
    MANAGER_GROUP(24, "店长的下线消费额返现通知短信"),
    MANAGER_STUDIO_MONEY(25, "店长工作室收益通知短信"),
    BAN_OFFICIAL_MANAGER(26, "冻结正式店长短信"),
    BAN_MANAGER_STUDIO(27, "冻结店长工作室短信"),
    AGENT_REMIND(28, "客服提醒短信");

    private int val;
    private String des;

    SmsCodeTypeEnum(int value, String des) {
        this.val = value;
        this.des = des;
    }

    public int val() {
        return val;
    }

    public String des() {
        return des;
    }
}
