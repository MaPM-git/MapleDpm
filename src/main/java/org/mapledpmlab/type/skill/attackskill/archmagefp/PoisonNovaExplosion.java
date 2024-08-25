package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonNovaExplosion extends AttackSkill {
    public PoisonNovaExplosion() {
        this.setName("포이즌 노바(폭발 1, 2, 3타)");
        this.setDamage(495.0);
        this.setAttackCount(12L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setRelatedSkill(new PoisonNovaExplosionAfterThird());
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}
