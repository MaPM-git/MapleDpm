package org.mapledpmlab.type.skill.buffskill.len;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PlumBlossomSecretApricotTree extends BuffSkill {
    public PlumBlossomSecretApricotTree() {
        this.setName("매화검 절기 : 만리향");
        this.setDelayByAttackSpeed(690L);
        this.setCooldown(120.0);
        this.setDuration(30L);
    }
}
