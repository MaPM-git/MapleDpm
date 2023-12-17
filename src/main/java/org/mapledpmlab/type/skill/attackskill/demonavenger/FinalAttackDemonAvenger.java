package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class FinalAttackDemonAvenger extends GaugeAttackSkill {
    public FinalAttackDemonAvenger() {
        this.setName("파이널 어택");
        this.setAttackCount(2L);
        this.setDamage(204.0);
        this.setProp(74L + 10);     // 익시드-보너스 찬스
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);   // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
