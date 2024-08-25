package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SummonThrowingWingDagger extends AttackSkill {
    public SummonThrowingWingDagger() {
        this.setName("서먼 스로잉 윙대거");
        this.setDamage(205.0 + 100 + 177);
        this.setAttackCount(1L);
        this.setDelay(150L);
        //this.setDelayByAttackSpeed(780L);
        this.setDotDuration(7000L);
        this.setInterval(330L);
        this.setLimitAttackCount(5L);
        this.addFinalDamage(1.3);           // 연계
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);        // 논체인아츠-리인포스, 보스 킬러
    }
}
