package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UltimateMovingMatter extends AttackSkill {
    public UltimateMovingMatter() {
        this.setName("얼티메이트-무빙 매터");
        this.setDamage(1100.0);
        this.setDelay(630L);
        this.setAttackCount(5L);
        this.setCooldown(90.0);
        this.setDotDuration(30000L);
        this.setInterval(390L);
        this.setLimitAttackCount(72L);
        this.addFinalDamage(1.6);   // 코어강화
        this.setRelatedSkill(new UltimateMovingMatterExtinction());
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
