package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonNovaExplosion extends AttackSkill {
    public PoisonNovaExplosion() {
        this.setName("포이즌 노바(폭발 1, 2타)");
        this.setDamage(495.0);
        this.setAttackCount(36L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setRelatedSkill(new PoisonNovaExplosionAfterThird());
    }
}
