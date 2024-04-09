package org.mapledpmlab.type.skill.buffskill.zero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class TranscendentLife extends BuffSkill {
    public TranscendentLife() {
        this.setName("트랜센던트(생명)");
        this.setDuration(30L);
        this.addBuffFinalDamage(1.05);
        this.setCooldown(120.0);
        this.setRelatedSkill(new TranscendentLight());
    }
}
