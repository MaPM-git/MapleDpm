package org.mapledpmlab.type.skill.buffskill.angelicbuster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.angelicbuster.CheeringBalloonFinale;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class GrandFinaleBuff extends BuffSkill {
    public GrandFinaleBuff() {
        this.setName("그랜드 피날레");
        this.setDuration(30L);
        this.setRelatedSkill(new CheeringBalloonFinale());
    }
}
