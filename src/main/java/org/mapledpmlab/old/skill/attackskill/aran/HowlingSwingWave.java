package org.mapledpmlab.old.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HowlingSwingWave extends AttackSkill {
    public HowlingSwingWave() {
        this.setName("하울링 스윙(파동)");
        this.setAttackCount(10L);
        this.setDamage(600.0 + 100);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new SwingResearch());
    }
}
