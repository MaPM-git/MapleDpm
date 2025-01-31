package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WingBeat extends AttackSkill {
    public WingBeat() {
        this.setName("윙 비트");
        this.setDamage(200.0);
        this.setAttackCount(1L);
        this.setDelayByAttackSpeed(360L);
        this.setDotDuration(15000L);
        this.setInterval(330L);
        this.setLimitAttackCount(40L);
        this.setAddDamage(20L);             // 윙비트-리인포스
        this.addFinalDamage(2.8);           // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
