package org.mapledpmlab.type.skill.buffskill.lara;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ManifestationSunlightFilledGround extends BuffSkill {
    public ManifestationSunlightFilledGround() {
        this.setName("발현 : 햇살 가득 안은 터");
        this.setDelayByAttackSpeed(480L);
        this.setCooldown(120.0 * 1.95);
        this.setDuration(120L);
        this.addBuffDamage(25L);
        this.setApplyPlusBuffDuration(true);
        this.setApplyCooldownReduction(false);
    }
}
