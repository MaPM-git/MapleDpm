package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LiberateNeptunus extends AttackSkill {
    public LiberateNeptunus() {
        this.setName("리버레이트 넵투누스");
        this.setAttackCount(8L);
        this.setCooldown(360.0);
        this.setDamage(3000.0);
        this.setApplyFinalAttack(true);
        this.setLimitAttackCount(3L);
        this.setDotDuration(3600L);
        this.setInterval(1200L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new LiberateNeptunusFuryOfTheSea());
    }
}
