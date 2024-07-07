package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class DemonImpactChain extends GaugeAttackSkill {
    public DemonImpactChain() {
        this.setName("데몬 임팩트 : 데몬 체인");
        this.setAttackCount(6L + 1);    // 데몬 임팩트-보너스 어택
        this.addFinalDamage(0.95);          // 블루 블러드
        this.setAttackCount(this.getAttackCount() * 2);
        this.setDamage(900.0 + 90);
        this.setDelayByAttackSpeed(870L);
        this.addIgnoreDefenseList(40L);
        this.setAddDamage(45L + 20);    // 데몬 임팩트-리인포스
        this.setCooldown(15.0);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(50.0);
    }
}
