package org.mapledpmlab.type.skill.buffskill.demonslayer;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class DemonicFortitude extends GaugeBuffSkill {
    public DemonicFortitude() {
        this.setName("데모닉 포티튜드");
        this.setCooldown(120.0);
        this.setDuration(60L);
        this.setBuffDamage(10L);
        this.setGaugeCharge(-10.0);
        this.setApplyServerLag(true);
        this.setDelay(30L);
    }
}
