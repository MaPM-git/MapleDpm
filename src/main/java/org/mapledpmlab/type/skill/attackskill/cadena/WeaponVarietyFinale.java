package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WeaponVarietyFinale extends AttackSkill {
    public WeaponVarietyFinale() {
        this.setName("웨폰 버라이어티 피날레");
        this.setDamage(550.0);
        this.setAttackCount(7L);
        this.setCooldown(11.0);
        this.addFinalDamage(1.6);
        this.setApplyCooldownReduction(false);
        this.getMultiAttackInfo().add(1050L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
    }
}
