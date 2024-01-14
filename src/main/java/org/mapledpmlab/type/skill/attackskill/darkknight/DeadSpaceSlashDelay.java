package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeadSpaceSlashDelay extends AttackSkill {
    public DeadSpaceSlashDelay() {
        this.setName("데드 스페이스(참격)");
        this.setDelay(5180L);
        this.setRelatedSkill(new DeadSpaceDarkAura());
    }
}
