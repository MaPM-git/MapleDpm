package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.shadower.VeilOfShadowBuff;

public class VeilOfShadow extends AttackSkill {
    public VeilOfShadow() {
        this.setName("베일 오브 섀도우");
        this.setAttackCount(1L);
        this.setDamage(1280.0);
        this.setCooldown(60.0);
        this.setDotDuration(12000L);
        this.setInterval(900L);
        this.setFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new VeilOfShadowBuff());
    }
}
