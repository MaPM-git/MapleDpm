package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DivineCharge extends AttackSkill {
    public DivineCharge() {
        this.setName("디바인 차지");
        this.setDamage(310.0 + 104.0);  // 디바인 스티그마 패시브
        this.setDelayByAttackSpeed(810L);
        this.setAttackCount(4 + 1L);    // 어드밴스드 홀리 차지
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
