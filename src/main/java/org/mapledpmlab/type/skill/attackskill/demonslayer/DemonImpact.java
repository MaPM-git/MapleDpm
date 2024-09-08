package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class DemonImpact extends GaugeAttackSkill {
    public DemonImpact() {
        this.setName("데몬 임팩트");
        this.setAttackCount(6L + 1);    // 데몬 임팩트-보너스 어택
        this.addFinalDamage(0.95);          // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(690.0 + 70);
        this.setDelayByAttackSpeed(780L);
        this.addIgnoreDefenseList(40L);
        this.setAddDamage(45L + 20);    // 데몬 임팩트-리인포스
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(-8.0);
    }
}
