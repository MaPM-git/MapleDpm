package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MechaCarrierSummon extends AttackSkill {
    public MechaCarrierSummon() {
        this.setName("메카 캐리어");
        this.setDelay(720L);
        this.setRelatedSkill(new MechaCarrier());
        this.setCooldown(180.0);
    }
}
