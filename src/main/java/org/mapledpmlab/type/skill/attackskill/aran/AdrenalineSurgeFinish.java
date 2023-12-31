package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdrenalineSurgeFinish extends AttackSkill {
    public AdrenalineSurgeFinish() {
        this.setName("아드레날린 서지(최후의 일격)");
        this.setAttackCount(14L);
        this.setDamage(8400.0 + 100);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setDotDuration(6240L);
        this.setLimitAttackCount(12L);
        this.setInterval(520L);
        this.setRelatedSkill(new AdrenalineSurgeFinishDelay());
    }
}
