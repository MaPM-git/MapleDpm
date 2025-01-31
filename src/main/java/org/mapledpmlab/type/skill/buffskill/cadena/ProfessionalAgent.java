package org.mapledpmlab.type.skill.buffskill.cadena;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ProfessionalAgent extends BuffSkill {
    public ProfessionalAgent() {
        this.setName("프로페셔널 에이전트");
        this.setDelayByAttackSpeed(720L);
        this.setDuration(30L);
        this.setCooldown(180.0);
        this.setApplyServerLag(true);
    }
}
