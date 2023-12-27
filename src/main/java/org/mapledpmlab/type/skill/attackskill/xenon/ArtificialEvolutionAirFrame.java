package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ArtificialEvolutionAirFrame extends AttackSkill {
    public ArtificialEvolutionAirFrame() {
        this.setName("아티피셜 에볼루션(에어프레임)");
        this.setAttackCount(18L * 2);
        this.setDamage(1800.0);
        this.setDotDuration(30000L);
        this.setInterval(1800L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.addFinalDamage(0.85);          // 버추얼 프로텍션
    }
}
