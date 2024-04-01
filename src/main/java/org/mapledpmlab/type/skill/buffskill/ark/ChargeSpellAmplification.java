package org.mapledpmlab.type.skill.buffskill.ark;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ChargeSpellAmplification extends BuffSkill {
    public ChargeSpellAmplification() {
        this.setName("차지 스펠 앰플리피케이션");
        this.setDelay(720L);
        this.setCooldown(120.0);
        this.setDuration(60L);
        this.addBuffAttMagic(30L);
        this.addBuffDamage(20L);            // 어비스 버프
        this.addBuffDamage(35L);
        this.addBuffIgnoreDefense(20L);
    }
}
