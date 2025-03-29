package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class FinalAttackDemonAvenger extends GaugeAttackSkill {
    public FinalAttackDemonAvenger() {
        this.setName("인핸스드 익시드");
        this.setAttackCount(2L);
        this.setDamage(405.0);
        this.setProp(80L + 10);     // 익시드-보너스 찬스
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(30L);     // 아티팩트
    }
}
