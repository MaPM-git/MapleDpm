package org.mapledpmlab.type.skill.buffskill.demonslayer;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.demonslayer.Nemea;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class Orthrus extends GaugeBuffSkill {
    public Orthrus() {
        this.setName("오르트로스");
        this.setCooldown(120.0);
        this.setDelay(490L);
        this.setRelatedSkill(new Nemea());
        this.setGaugeCharge(-30.0);
        this.setDuration(55L);
    }
}
