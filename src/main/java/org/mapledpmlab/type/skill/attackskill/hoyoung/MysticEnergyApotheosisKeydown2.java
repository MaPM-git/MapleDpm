package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MysticEnergyApotheosisKeydown2 extends AttackSkill {
    public MysticEnergyApotheosisKeydown2() {
        this.setName("선기 : 파천황(선기)");
        this.setAttackCount(15L);
        this.setDamage(1240.0);
        this.setDelay(2900L);
        this.setDotDuration(2730L);
        this.setInterval(210L);
        this.setLimitAttackCount(13L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.setRelatedSkill(new MysticEnergyApotheosisFinish());
    }
}
