package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class ExceedExecution3 extends GaugeAttackSkill {
    public ExceedExecution3() {
        this.setName("익시드 : 엑스큐션(3단계)");
        this.setAttackCount(4L);
        this.setDamage(548.0);
        this.setDelayByAttackSpeed(840L);
        this.addIgnoreDefenseList(31L);
        this.setGaugePer(-5L);
        this.setAddDamage(20L);     // 익시드-리인포스
        this.addFinalDamage(2.2);   // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
