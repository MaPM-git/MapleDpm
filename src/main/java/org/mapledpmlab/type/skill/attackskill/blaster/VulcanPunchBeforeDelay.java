package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class VulcanPunchBeforeDelay extends AttackSkill {
    public VulcanPunchBeforeDelay() {
        this.setName("발칸 펀치(선딜)");
        this.setDelayByAttackSpeed(720L);
        this.setRelatedSkill(new VulcanPunchKeydown());
    }
}
