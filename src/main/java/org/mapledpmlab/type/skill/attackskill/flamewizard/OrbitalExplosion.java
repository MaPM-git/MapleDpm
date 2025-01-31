package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class OrbitalExplosion extends AttackSkill {
    public OrbitalExplosion() {
        this.setName("오비탈 익스플로젼");
        this.setDamage(330.0);
        this.setAttackCount(3L);
        this.addFinalDamage(2.8);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
