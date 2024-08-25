package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GhostDispositionAttack extends AttackSkill {
    public GhostDispositionAttack() {
        this.setName("귀문진(기운)");
        this.setAttackCount(10L);
        this.setDamage(275.0);
        this.setDelay(840L);
        this.getMultiAttackInfo().add(420L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setRelatedSkill(new GhostDispositionDarkness());
    }
}
