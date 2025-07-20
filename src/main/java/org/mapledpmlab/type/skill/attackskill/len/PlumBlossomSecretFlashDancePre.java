package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PlumBlossomSecretFlashDancePre extends AttackSkill {
    public PlumBlossomSecretFlashDancePre() {
        this.setName("매화검 절기 : 섬무(선딜)");
        this.setCooldown(120.0);
        this.setDelay(120L);
        this.setRelatedSkill(new PlumBlossomSecretFlashDance());
    }
}