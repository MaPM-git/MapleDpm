package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MysticEnergyApotheosisKeydown1 extends AttackSkill {
    public MysticEnergyApotheosisKeydown1() {
        this.setName("선기 : 파천황(키다운)");
        this.setAttackCount(8L);
        this.setCooldown(360.0);
        this.setDamage(1013.0);
        this.setDelay(2100L);
        this.setDotDuration(2100L);
        this.setInterval(210L);
        this.setLimitAttackCount(10L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.setRelatedSkill(new MysticEnergyApotheosisKeydown2());
    }
}
