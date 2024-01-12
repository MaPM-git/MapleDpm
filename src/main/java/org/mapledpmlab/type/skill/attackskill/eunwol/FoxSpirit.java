package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FoxSpirit extends AttackSkill {
    public FoxSpirit() {
        this.setName("여우령");
        this.setDamage(205.0);
        this.setAttackCount(1L);
        this.setDotDuration(600L * 4);
        this.setInterval(600L);
        this.setLimitAttackCount(4L);       // 불여우령-리핏 어택 보너스
        this.setProp(25L + 10);             // 불여우령-서먼 찬스
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
