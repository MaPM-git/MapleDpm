package org.mapledpmlab.type.skill.attackskill.zero;

public class ThrowingWeapon extends AssistSkill {
    public ThrowingWeapon() {
        this.setName("스로잉 웨폰");
        this.setAttackCount(4L);
        this.setDamage(870.0);
        //this.setDelayByAttackSpeed(480L);
        this.setDelay(480L);
        this.setDotDuration(4000L);
        this.setInterval(300L);
        this.setLimitAttackCount(5L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAssistDelay(480L);
    }
}
