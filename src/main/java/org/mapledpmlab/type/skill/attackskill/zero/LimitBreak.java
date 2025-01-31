package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.zero.LimitBreakBuff;

public class LimitBreak extends AttackSkill {
    public LimitBreak() {
        this.setName("리미트 브레이크");
        this.setAttackCount(5L);
        this.setDamage(450.0);
        this.setDelayByAttackSpeed(600L);
        this.setCooldown(120.0);
        this.setRelatedSkill(new LimitBreakBuff());
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
