package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WingBeat extends AttackSkill {
    public WingBeat() {
        this.setName("윙 비트");
        this.setDamage(200.0);
        this.setAttackCount(1L);
        this.setDelayByAttackSpeed(360L);
        this.setDotDuration(15000L + 5000); // 윙비트-퍼시스트
        this.setInterval(330L);
        this.setLimitAttackCount(40L + 8);  // 윙비트-엑스트라 어택
        this.setAddDamage(20L);             // 윙비트-리인포스
        this.addFinalDamage(2.8);           // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
