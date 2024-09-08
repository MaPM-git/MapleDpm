package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UltimateMovingMatterExtinction extends AttackSkill {
    public UltimateMovingMatterExtinction() {
        this.setName("얼티메이트-무빙 매터(소멸)");
        this.setDamage(1045.0);
        this.setAttackCount(12L);
        this.addFinalDamage(1.6);   // 코어강화
        this.getMultiAttackInfo().add(15000L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
