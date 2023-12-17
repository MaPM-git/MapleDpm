package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class ExceedExecution5 extends GaugeAttackSkill {
    public ExceedExecution5() {
        this.setName("익시드 : 엑스큐션(5단계)");
        this.setAttackCount(6L);
        this.setDamage(548.0);
        this.setDelayByAttackSpeed(720L);
        this.addIgnoreDefenseList(31L);
        this.setGaugePer(-6L);
        this.setAddDamage(20L);     // 익시드-리인포스
        this.addFinalDamage(2.2);   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
