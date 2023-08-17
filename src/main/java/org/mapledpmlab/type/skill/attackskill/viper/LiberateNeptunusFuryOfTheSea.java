package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LiberateNeptunusFuryOfTheSea extends AttackSkill {
    public LiberateNeptunusFuryOfTheSea() {
        this.setName("리버레이트 넵투누스(바다의 분노)");
        this.setAttackCount(12L);
        this.setCooldown(360.0);
        this.setDamage(4500.0);
        this.setApplyFinalAttack(true);
        this.setLimitAttackCount(7L);
        this.setDotDuration(1260L);
        this.setInterval(180L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new LiberateNeptunusDelay());
    }
}
