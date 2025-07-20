package org.mapledpmlab.type.skill.attackskill.mercedes;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;

@Getter
@Setter
public class Sylphidia extends AttackSkill {
    public Sylphidia() {
        this.setName("실피디아(돌격)");
        this.setDelayByAttackSpeed(660L);
        this.setCooldown(60.0);
        this.setDamage(1650.0);
        this.setAttackCount(13L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.setRelatedSkill(new SylphidiaAfterImage());
    }
}
