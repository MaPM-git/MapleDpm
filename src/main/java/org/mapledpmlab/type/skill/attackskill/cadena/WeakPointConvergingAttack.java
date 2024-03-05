package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WeakPointConvergingAttack extends AttackSkill {
    public WeakPointConvergingAttack() {
        this.setName("위크 포인트 컨버징 어택");
        this.setDamage(112.0);
        this.setAttackCount(1L);
        this.setDotDuration(720000L);
        this.setInterval(1000L);
    }
}
