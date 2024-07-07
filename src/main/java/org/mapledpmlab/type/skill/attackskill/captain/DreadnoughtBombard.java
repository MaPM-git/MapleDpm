package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DreadnoughtBombard extends AttackSkill {
    public DreadnoughtBombard() {
        this.setName("드레드노트(폭격)");
        this.setDamage(1500.0);
        this.setAttackCount(8L);
        this.setDotDuration(15000L);
        this.setInterval(187L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
    }
}
