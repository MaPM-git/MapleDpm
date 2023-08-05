package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ComboInstinctsAttack extends AttackSkill {
    public ComboInstinctsAttack() {
        this.setName("콤보 인스팅트(공간의 상처)");
        this.setAttackCount(6L);
        this.setDamage(355.0);
        this.setFinalAttack(true);
        this.setFinalDamage(1.6);
        this.setProp(100L);
        this.setInterval(1L);
        this.setLimitAttackCount(3L);
        this.setDotDuration(3L);
    }
}
