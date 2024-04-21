package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ComboInstinctsAttack extends AttackSkill {
    public ComboInstinctsAttack() {
        this.setName("콤보 인스팅트(공간의 상처)");
        this.setAttackCount(6L);
        this.setDamage(355.0);
        this.setFinalDamage(1.6);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}
