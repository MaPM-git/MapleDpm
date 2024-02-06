package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LiberateNeptunus extends AttackSkill {
    public LiberateNeptunus() {
        this.setName("리버레이트 넵투누스");
        this.setAttackCount(13L);
        this.setCooldown(360.0);
        this.setDamage(1380.0);
        this.setApplyFinalAttack(true);
        this.setDelay(2580L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new LiberateNeptunusFuryOfTheSea());
        this.getMultiAttackInfo().add(2220L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
    }
}
