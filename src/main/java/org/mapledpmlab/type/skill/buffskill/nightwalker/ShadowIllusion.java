package org.mapledpmlab.type.skill.buffskill.nightwalker;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ShadowIllusion extends BuffSkill {
    public ShadowIllusion() {
        this.setName("쉐도우 일루전");
        this.setCooldown(120.0);
        this.setDelay(360L);
        //this.setDelay(690L);
        this.setDuration(20L);
    }
}
